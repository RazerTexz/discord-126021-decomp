package org.objectweb.asm;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/FieldVisitor.SCL.lombok */
public abstract class FieldVisitor {
    protected final int api;

    /* JADX INFO: renamed from: fv */
    protected FieldVisitor f27599fv;

    public FieldVisitor(int api) {
        this(api, null);
    }

    public FieldVisitor(int api, FieldVisitor fieldVisitor) {
        if (api != 589824 && api != 524288 && api != 458752 && api != 393216 && api != 327680 && api != 262144 && api != 17432576) {
            throw new IllegalArgumentException("Unsupported api " + api);
        }
        if (api == 17432576) {
            Constants.checkAsmExperimental(this);
        }
        this.api = api;
        this.f27599fv = fieldVisitor;
    }

    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        if (this.f27599fv != null) {
            return this.f27599fv.visitAnnotation(descriptor, visible);
        }
        return null;
    }

    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        if (this.api < 327680) {
            throw new UnsupportedOperationException("This feature requires ASM5");
        }
        if (this.f27599fv != null) {
            return this.f27599fv.visitTypeAnnotation(typeRef, typePath, descriptor, visible);
        }
        return null;
    }

    public void visitAttribute(Attribute attribute) {
        if (this.f27599fv != null) {
            this.f27599fv.visitAttribute(attribute);
        }
    }

    public void visitEnd() {
        if (this.f27599fv != null) {
            this.f27599fv.visitEnd();
        }
    }
}
