[//]: # (#Design git like version control system)

[//]: # (Instead of storing objects as files on the filesystem, 
        you can use in-memory collections such as HashMap to represent blobs, trees, and commits.)

[//]: # (We use HashMap to mimic the object store for blobs, trees, and commits.)

[//]: # (Blob Store: Holds blob objects &#40;file contents&#41;.)

[//]: # (Tree Store: Holds tree objects &#40;directory structures&#41;.)

[//]: # (Commit Store: Holds commit objects &#40;snapshot of changes&#41;.)

[//]: # (Blob Creation: Content is hashed and stored in blobStore.)

[//]: # (Tree Creation: Blob hashes are grouped to form a tree, stored in treeStore.)

[//]: # (Commit Creation: Commits reference tree hashes, parent commits, and messages, stored in commitStore.)