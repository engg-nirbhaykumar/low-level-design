package com.design.lld.git;

public class Commit {
    private final String treeHash;
    private final String parentHash;
    private final String message;

    public Commit(String treeHash, String parentHash, String message) {
        this.treeHash = treeHash;
        this.parentHash = parentHash;
        this.message = message;
    }

    public String getTreeHash() {
        return treeHash;
    }

    public String getParentHash() {
        return parentHash;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return String.format("Tree: %s, Parent: %s, Message: %s", treeHash, parentHash, message);
    }
}
