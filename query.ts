#!/usr/bin/env -S deno run --allow-net -RW

import { dedent } from "https://jsr.io/@cliffy/command/1.0.0-rc.7/_utils.ts"
import { Command } from "jsr:@cliffy/command@1.0.0-rc.7"

interface Kata {
    id: string
    name: string
    slug: string
    category: string
    publishedAt: string
    approvedAt: string
    languages: string[]
    url: string
    rank: Rank
    createdAt: string
    createdBy: User
    approvedBy: User
    description: string
    totalAttempts: number
    totalCompleted: number
    totalStars: number
    voteScore: number
    tags: string[]
    contributorsWanted: boolean
    unresolved: Unresolved
}

interface Rank {
    id: number
    name: string
    color: string
}

interface User {
    username: string
    url: string
}

interface Unresolved {
    issues: number
    suggestions: number
}

const fmtRank = (rank: Rank) => rank.name.replace(" ", "")
const getId = (urlOrId: string) => /kata\/(\w+)/.exec(urlOrId)?.[1] ?? urlOrId

if (import.meta.main) {
    const { options: { dryRun }, args: [urlOrId] } = await new Command()
        .description("Fetch and create a template for a Codewars kata")
        .option("-D --dry-run", "Dry run, do not create file", {
            default: false,
        })
        .arguments("<urlOrId:string>")
        .parse(Deno.args)

    const id = getId(urlOrId)

    const response = await fetch(
        `https://www.codewars.com/api/v1/code-challenges/${id}`,
    )

    const text = await response.text()
    const kata = JSON.parse(text) as Kata
    console.log(kata)
    const rank = fmtRank(kata.rank)

    const template = dedent(`
        /** ${kata.url} */
        package \`${rank}\`.${kata.slug.replace(/-/g, "")}


        // tests go here
    `)

    if (!dryRun) {
        await Deno.mkdir(rank, { recursive: true })
        await Deno.writeTextFile(
            `${import.meta.dirname}/${rank}/${kata.slug}.scala`,
            template,
        )
    }
}
