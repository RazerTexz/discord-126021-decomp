package org.objectweb.asm.tree;

import java.util.ArrayList;
import java.util.List;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ModuleVisitor;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/tree/ModuleNode.SCL.lombok */
public class ModuleNode extends ModuleVisitor {
    public String name;
    public int access;
    public String version;
    public String mainClass;
    public List<String> packages;
    public List<ModuleRequireNode> requires;
    public List<ModuleExportNode> exports;
    public List<ModuleOpenNode> opens;
    public List<String> uses;
    public List<ModuleProvideNode> provides;

    public ModuleNode(String name, int access, String version) {
        super(Opcodes.ASM9);
        if (getClass() != ModuleNode.class) {
            throw new IllegalStateException();
        }
        this.name = name;
        this.access = access;
        this.version = version;
    }

    public ModuleNode(int api, String name, int access, String version, List<ModuleRequireNode> requires, List<ModuleExportNode> exports, List<ModuleOpenNode> opens, List<String> uses, List<ModuleProvideNode> provides) {
        super(api);
        this.name = name;
        this.access = access;
        this.version = version;
        this.requires = requires;
        this.exports = exports;
        this.opens = opens;
        this.uses = uses;
        this.provides = provides;
    }

    @Override // org.objectweb.asm.ModuleVisitor
    public void visitMainClass(String mainClass) {
        this.mainClass = mainClass;
    }

    @Override // org.objectweb.asm.ModuleVisitor
    public void visitPackage(String packaze) {
        if (this.packages == null) {
            this.packages = new ArrayList(5);
        }
        this.packages.add(packaze);
    }

    @Override // org.objectweb.asm.ModuleVisitor
    public void visitRequire(String module, int access, String version) {
        if (this.requires == null) {
            this.requires = new ArrayList(5);
        }
        this.requires.add(new ModuleRequireNode(module, access, version));
    }

    @Override // org.objectweb.asm.ModuleVisitor
    public void visitExport(String packaze, int access, String... modules) {
        if (this.exports == null) {
            this.exports = new ArrayList(5);
        }
        this.exports.add(new ModuleExportNode(packaze, access, Util.asArrayList(modules)));
    }

    @Override // org.objectweb.asm.ModuleVisitor
    public void visitOpen(String packaze, int access, String... modules) {
        if (this.opens == null) {
            this.opens = new ArrayList(5);
        }
        this.opens.add(new ModuleOpenNode(packaze, access, Util.asArrayList(modules)));
    }

    @Override // org.objectweb.asm.ModuleVisitor
    public void visitUse(String service) {
        if (this.uses == null) {
            this.uses = new ArrayList(5);
        }
        this.uses.add(service);
    }

    @Override // org.objectweb.asm.ModuleVisitor
    public void visitProvide(String service, String... providers) {
        if (this.provides == null) {
            this.provides = new ArrayList(5);
        }
        this.provides.add(new ModuleProvideNode(service, Util.asArrayList(providers)));
    }

    @Override // org.objectweb.asm.ModuleVisitor
    public void visitEnd() {
    }

    public void accept(ClassVisitor classVisitor) {
        ModuleVisitor moduleVisitor = classVisitor.visitModule(this.name, this.access, this.version);
        if (moduleVisitor == null) {
            return;
        }
        if (this.mainClass != null) {
            moduleVisitor.visitMainClass(this.mainClass);
        }
        if (this.packages != null) {
            int n = this.packages.size();
            for (int i = 0; i < n; i++) {
                moduleVisitor.visitPackage(this.packages.get(i));
            }
        }
        if (this.requires != null) {
            int n2 = this.requires.size();
            for (int i2 = 0; i2 < n2; i2++) {
                this.requires.get(i2).accept(moduleVisitor);
            }
        }
        if (this.exports != null) {
            int n3 = this.exports.size();
            for (int i3 = 0; i3 < n3; i3++) {
                this.exports.get(i3).accept(moduleVisitor);
            }
        }
        if (this.opens != null) {
            int n4 = this.opens.size();
            for (int i4 = 0; i4 < n4; i4++) {
                this.opens.get(i4).accept(moduleVisitor);
            }
        }
        if (this.uses != null) {
            int n5 = this.uses.size();
            for (int i5 = 0; i5 < n5; i5++) {
                moduleVisitor.visitUse(this.uses.get(i5));
            }
        }
        if (this.provides != null) {
            int n6 = this.provides.size();
            for (int i6 = 0; i6 < n6; i6++) {
                this.provides.get(i6).accept(moduleVisitor);
            }
        }
    }
}
