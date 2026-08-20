package org.objectweb.asm.tree;

import java.util.List;
import org.objectweb.asm.ModuleVisitor;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/tree/ModuleOpenNode.SCL.lombok */
public class ModuleOpenNode {
    public String packaze;
    public int access;
    public List<String> modules;

    public ModuleOpenNode(String packaze, int access, List<String> modules) {
        this.packaze = packaze;
        this.access = access;
        this.modules = modules;
    }

    public void accept(ModuleVisitor moduleVisitor) {
        moduleVisitor.visitOpen(this.packaze, this.access, this.modules == null ? null : (String[]) this.modules.toArray(new String[0]));
    }
}
