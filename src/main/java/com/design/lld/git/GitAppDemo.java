package com.design.lld.git;

import java.util.Arrays;
import java.util.List;

public class GitAppDemo {
    public static void run() {
        GitApp git = new GitApp();

        // Step 1: Create a blob
        String blob1 = git.createBlob("Hello, Git!");
        String blob2 = git.createBlob("Git is awesome!");

        // Step 2: Read the blob
        System.out.println("Blob 1 content: " + git.readBlob(blob1));

        // Step 3: Create a tree
        List<String> blobs = Arrays.asList(blob1, blob2);
        String treeHash = git.createTree(blobs);

        // Step 4: Read the tree
        System.out.println("Tree content: " + git.readTree(treeHash));

        // Step 5: Create a commit
        String commitHash = git.createCommit(treeHash, null, "Initial commit");

        // Step 6: Read the commit
        Commit commit = git.readCommit(commitHash);
        System.out.println("Commit details: " + commit);
    }

    public static void main(String[] args) {
        run();
    }
}
