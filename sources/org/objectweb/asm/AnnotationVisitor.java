package org.objectweb.asm;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/AnnotationVisitor.SCL.lombok */
public abstract class AnnotationVisitor {
    protected final int api;

    /* JADX INFO: renamed from: av */
    protected AnnotationVisitor f27596av;

    public AnnotationVisitor(int api) {
        this(api, null);
    }

    public AnnotationVisitor(int api, AnnotationVisitor annotationVisitor) {
        if (api != 589824 && api != 524288 && api != 458752 && api != 393216 && api != 327680 && api != 262144 && api != 17432576) {
            throw new IllegalArgumentException("Unsupported api " + api);
        }
        if (api == 17432576) {
            Constants.checkAsmExperimental(this);
        }
        this.api = api;
        this.f27596av = annotationVisitor;
    }

    public void visit(String name, Object value) {
        if (this.f27596av != null) {
            this.f27596av.visit(name, value);
        }
    }

    public void visitEnum(String name, String descriptor, String value) {
        if (this.f27596av != null) {
            this.f27596av.visitEnum(name, descriptor, value);
        }
    }

    public AnnotationVisitor visitAnnotation(String name, String descriptor) {
        if (this.f27596av != null) {
            return this.f27596av.visitAnnotation(name, descriptor);
        }
        return null;
    }

    public AnnotationVisitor visitArray(String name) {
        if (this.f27596av != null) {
            return this.f27596av.visitArray(name);
        }
        return null;
    }

    public void visitEnd() {
        if (this.f27596av != null) {
            this.f27596av.visitEnd();
        }
    }
}
