package com.zhixiangli.code.similarity;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

class Bar {
    static int test() {
		System.out.println("test");
        Set<Path> workspaceRoots = new HashSet<>();
        workspaceRoots.add(Paths.get("src/test/examples/incremental-compile/src").toAbsolutePath());
        return 1;
    }
}