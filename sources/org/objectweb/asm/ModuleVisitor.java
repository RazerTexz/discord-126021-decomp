package org.objectweb.asm;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/ModuleVisitor.SCL.lombok */
public abstract class ModuleVisitor {
    protected final int api;

    /* JADX INFO: renamed from: mv */
    protected ModuleVisitor f27602mv;

    public ModuleVisitor(int api) {
        this(api, null);
    }

    public ModuleVisitor(int api, ModuleVisitor moduleVisitor) {
        if (api != 589824 && api != 524288 && api != 458752 && api != 393216 && api != 327680 && api != 262144 && api != 17432576) {
            throw new IllegalArgumentException("Unsupported api " + api);
        }
        if (api == 17432576) {
            Constants.checkAsmExperimental(this);
        }
        this.api = api;
        this.f27602mv = moduleVisitor;
    }

    public void visitMainClass(String mainClass) {
        if (this.f27602mv != null) {
            this.f27602mv.visitMainClass(mainClass);
        }
    }

    public void visitPackage(String packaze) {
        if (this.f27602mv != null) {
            this.f27602mv.visitPackage(packaze);
        }
    }

    public void visitRequire(String module, int access, String version) {
        if (this.f27602mv != null) {
            this.f27602mv.visitRequire(module, access, version);
        }
    }

    public void visitExport(String packaze, int access, String... modules) {
        if (this.f27602mv != null) {
            this.f27602mv.visitExport(packaze, access, modules);
        }
    }

    public void visitOpen(String packaze, int access, String... modules) {
        if (this.f27602mv != null) {
            this.f27602mv.visitOpen(packaze, access, modules);
        }
    }

    public void visitUse(String service) {
        if (this.f27602mv != null) {
            this.f27602mv.visitUse(service);
        }
    }

    public void visitProvide(String service, String... providers) {
        if (this.f27602mv != null) {
            this.f27602mv.visitProvide(service, providers);
        }
    }

    public void visitEnd() {
        if (this.f27602mv != null) {
            this.f27602mv.visitEnd();
        }
    }
}
