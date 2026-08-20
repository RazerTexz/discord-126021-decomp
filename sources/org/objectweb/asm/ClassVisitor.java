package org.objectweb.asm;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/ClassVisitor.SCL.lombok */
public abstract class ClassVisitor {
    protected final int api;

    /* JADX INFO: renamed from: cv */
    protected ClassVisitor f27598cv;

    public ClassVisitor(int api) {
        this(api, null);
    }

    public ClassVisitor(int api, ClassVisitor classVisitor) {
        if (api != 589824 && api != 524288 && api != 458752 && api != 393216 && api != 327680 && api != 262144 && api != 17432576) {
            throw new IllegalArgumentException("Unsupported api " + api);
        }
        if (api == 17432576) {
            Constants.checkAsmExperimental(this);
        }
        this.api = api;
        this.f27598cv = classVisitor;
    }

    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        if (this.api < 524288 && (access & 65536) != 0) {
            throw new UnsupportedOperationException("Records requires ASM8");
        }
        if (this.f27598cv != null) {
            this.f27598cv.visit(version, access, name, signature, superName, interfaces);
        }
    }

    public void visitSource(String source, String debug) {
        if (this.f27598cv != null) {
            this.f27598cv.visitSource(source, debug);
        }
    }

    public ModuleVisitor visitModule(String name, int access, String version) {
        if (this.api < 393216) {
            throw new UnsupportedOperationException("Module requires ASM6");
        }
        if (this.f27598cv != null) {
            return this.f27598cv.visitModule(name, access, version);
        }
        return null;
    }

    public void visitNestHost(String nestHost) {
        if (this.api < 458752) {
            throw new UnsupportedOperationException("NestHost requires ASM7");
        }
        if (this.f27598cv != null) {
            this.f27598cv.visitNestHost(nestHost);
        }
    }

    public void visitOuterClass(String owner, String name, String descriptor) {
        if (this.f27598cv != null) {
            this.f27598cv.visitOuterClass(owner, name, descriptor);
        }
    }

    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        if (this.f27598cv != null) {
            return this.f27598cv.visitAnnotation(descriptor, visible);
        }
        return null;
    }

    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        if (this.api < 327680) {
            throw new UnsupportedOperationException("TypeAnnotation requires ASM5");
        }
        if (this.f27598cv != null) {
            return this.f27598cv.visitTypeAnnotation(typeRef, typePath, descriptor, visible);
        }
        return null;
    }

    public void visitAttribute(Attribute attribute) {
        if (this.f27598cv != null) {
            this.f27598cv.visitAttribute(attribute);
        }
    }

    public void visitNestMember(String nestMember) {
        if (this.api < 458752) {
            throw new UnsupportedOperationException("NestMember requires ASM7");
        }
        if (this.f27598cv != null) {
            this.f27598cv.visitNestMember(nestMember);
        }
    }

    public void visitPermittedSubclass(String permittedSubclass) {
        if (this.api < 589824) {
            throw new UnsupportedOperationException("PermittedSubclasses requires ASM9");
        }
        if (this.f27598cv != null) {
            this.f27598cv.visitPermittedSubclass(permittedSubclass);
        }
    }

    public void visitInnerClass(String name, String outerName, String innerName, int access) {
        if (this.f27598cv != null) {
            this.f27598cv.visitInnerClass(name, outerName, innerName, access);
        }
    }

    public RecordComponentVisitor visitRecordComponent(String name, String descriptor, String signature) {
        if (this.api < 524288) {
            throw new UnsupportedOperationException("Record requires ASM8");
        }
        if (this.f27598cv != null) {
            return this.f27598cv.visitRecordComponent(name, descriptor, signature);
        }
        return null;
    }

    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
        if (this.f27598cv != null) {
            return this.f27598cv.visitField(access, name, descriptor, signature, value);
        }
        return null;
    }

    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        if (this.f27598cv != null) {
            return this.f27598cv.visitMethod(access, name, descriptor, signature, exceptions);
        }
        return null;
    }

    public void visitEnd() {
        if (this.f27598cv != null) {
            this.f27598cv.visitEnd();
        }
    }
}
