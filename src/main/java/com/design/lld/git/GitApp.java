package com.design.lld.git;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GitApp {
    private final Map<String, String> blobStore = new HashMap<>();
    private final Map<String, List<String>> treeStore = new HashMap<>();
    private final Map<String, Commit> commitStore = new HashMap<>();

    /**
     * Initializes the Git repository (in-memory stores).
     */
    public GitApp() {
        System.out.println("Initialized in-memory Git repository.");
    }

    /**
     * Creates a blob and stores it in the blob store.
     *
     * @param content The content of the blob.
     * @return The hash of the created blob.
     */
    public String createBlob(String content) {
        String hash = HashUtils.generateHash(content);
        blobStore.put(hash, content);
        System.out.println("Blob created with hash: " + hash);
        return hash;
    }

    /**
     * Reads a blob from the blob store by its hash.
     *
     * @param hash The hash of the blob.
     * @return The content of the blob.
     */
    public String readBlob(String hash) {
        String content = blobStore.get(hash);
        if (content == null) {
            System.err.println("Blob not found for hash: " + hash);
            return null;
        }
        return content;
    }

    /**
     * Creates a tree object from a list of blob hashes.
     *
     * @param blobs The list of blob hashes to include in the tree.
     * @return The hash of the created tree.
     */
    public String createTree(List<String> blobs) {
        String hash = HashUtils.generateHash(blobs.toString());
        treeStore.put(hash, blobs);
        System.out.println("Tree created with hash: " + hash);
        return hash;
    }

    /**
     * Reads a tree object from the tree store by its hash.
     *
     * @param hash The hash of the tree.
     * @return The list of blob hashes in the tree.
     */
    public List<String> readTree(String hash) {
        List<String> blobs = treeStore.get(hash);
        if (blobs == null) {
            System.err.println("Tree not found for hash: " + hash);
            return null;
        }
        return blobs;
    }

    /**
     * Creates a commit object and stores it in the commit store.
     *
     * @param treeHash   The hash of the tree object.
     * @param parentHash The hash of the parent commit (if any).
     * @param message    The commit message.
     * @return The hash of the created commit.
     */
    public String createCommit(String treeHash, String parentHash, String message) {
        Commit commit = new Commit(treeHash, parentHash, message);
        String hash = HashUtils.generateHash(commit.toString());
        commitStore.put(hash, commit);
        System.out.println("Commit created with hash: " + hash);
        return hash;
    }

    /**
     * Reads a commit object from the commit store by its hash.
     *
     * @param hash The hash of the commit.
     * @return The commit object.
     */
    public Commit readCommit(String hash) {
        Commit commit = commitStore.get(hash);
        if (commit == null) {
            System.err.println("Commit not found for hash: " + hash);
        }
        return commit;
    }
}
