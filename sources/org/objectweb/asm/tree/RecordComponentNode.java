package org.objectweb.asm.tree;

import java.util.List;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.RecordComponentVisitor;
import org.objectweb.asm.TypePath;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/tree/RecordComponentNode.SCL.lombok */
public class RecordComponentNode extends RecordComponentVisitor {
    public String name;
    public String descriptor;
    public String signature;
    public List<AnnotationNode> visibleAnnotations;
    public List<AnnotationNode> invisibleAnnotations;
    public List<TypeAnnotationNode> visibleTypeAnnotations;
    public List<TypeAnnotationNode> invisibleTypeAnnotations;
    public List<Attribute> attrs;

    public RecordComponentNode(String name, String descriptor, String signature) {
        this(Opcodes.ASM9, name, descriptor, signature);
        if (getClass() != RecordComponentNode.class) {
            throw new IllegalStateException();
        }
    }

    public RecordComponentNode(int api, String name, String descriptor, String signature) {
        super(api);
        this.name = name;
        this.descriptor = descriptor;
        this.signature = signature;
    }

    @Override // org.objectweb.asm.RecordComponentVisitor
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        AnnotationNode annotation = new AnnotationNode(descriptor);
        if (visible) {
            this.visibleAnnotations = Util.add(this.visibleAnnotations, annotation);
        } else {
            this.invisibleAnnotations = Util.add(this.invisibleAnnotations, annotation);
        }
        return annotation;
    }

    @Override // org.objectweb.asm.RecordComponentVisitor
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        TypeAnnotationNode typeAnnotation = new TypeAnnotationNode(typeRef, typePath, descriptor);
        if (visible) {
            this.visibleTypeAnnotations = Util.add(this.visibleTypeAnnotations, typeAnnotation);
        } else {
            this.invisibleTypeAnnotations = Util.add(this.invisibleTypeAnnotations, typeAnnotation);
        }
        return typeAnnotation;
    }

    @Override // org.objectweb.asm.RecordComponentVisitor
    public void visitAttribute(Attribute attribute) {
        this.attrs = Util.add(this.attrs, attribute);
    }

    @Override // org.objectweb.asm.RecordComponentVisitor
    public void visitEnd() {
    }

    public void check(int api) {
        if (api < 524288) {
            throw new UnsupportedClassVersionException();
        }
    }

    public void accept(ClassVisitor classVisitor) {
        RecordComponentVisitor recordComponentVisitor = classVisitor.visitRecordComponent(this.name, this.descriptor, this.signature);
        if (recordComponentVisitor == null) {
            return;
        }
        if (this.visibleAnnotations != null) {
            int n = this.visibleAnnotations.size();
            for (int i = 0; i < n; i++) {
                AnnotationNode annotation = this.visibleAnnotations.get(i);
                annotation.accept(recordComponentVisitor.visitAnnotation(annotation.desc, true));
            }
        }
        if (this.invisibleAnnotations != null) {
            int n2 = this.invisibleAnnotations.size();
            for (int i2 = 0; i2 < n2; i2++) {
                AnnotationNode annotation2 = this.invisibleAnnotations.get(i2);
                annotation2.accept(recordComponentVisitor.visitAnnotation(annotation2.desc, false));
            }
        }
        if (this.visibleTypeAnnotations != null) {
            int n3 = this.visibleTypeAnnotations.size();
            for (int i3 = 0; i3 < n3; i3++) {
                TypeAnnotationNode typeAnnotation = this.visibleTypeAnnotations.get(i3);
                typeAnnotation.accept(recordComponentVisitor.visitTypeAnnotation(typeAnnotation.typeRef, typeAnnotation.typePath, typeAnnotation.desc, true));
            }
        }
        if (this.invisibleTypeAnnotations != null) {
            int n4 = this.invisibleTypeAnnotations.size();
            for (int i4 = 0; i4 < n4; i4++) {
                TypeAnnotationNode typeAnnotation2 = this.invisibleTypeAnnotations.get(i4);
                typeAnnotation2.accept(recordComponentVisitor.visitTypeAnnotation(typeAnnotation2.typeRef, typeAnnotation2.typePath, typeAnnotation2.desc, false));
            }
        }
        if (this.attrs != null) {
            int n5 = this.attrs.size();
            for (int i5 = 0; i5 < n5; i5++) {
                recordComponentVisitor.visitAttribute(this.attrs.get(i5));
            }
        }
        recordComponentVisitor.visitEnd();
    }
}
