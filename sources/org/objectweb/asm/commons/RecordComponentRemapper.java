package org.objectweb.asm.commons;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.RecordComponentVisitor;
import org.objectweb.asm.TypePath;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/commons/RecordComponentRemapper.SCL.lombok */
public class RecordComponentRemapper extends RecordComponentVisitor {
    protected final Remapper remapper;

    public RecordComponentRemapper(RecordComponentVisitor recordComponentVisitor, Remapper remapper) {
        this(Opcodes.ASM9, recordComponentVisitor, remapper);
    }

    protected RecordComponentRemapper(int api, RecordComponentVisitor recordComponentVisitor, Remapper remapper) {
        super(api, recordComponentVisitor);
        this.remapper = remapper;
    }

    @Override // org.objectweb.asm.RecordComponentVisitor
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        AnnotationVisitor annotationVisitor = super.visitAnnotation(this.remapper.mapDesc(descriptor), visible);
        if (annotationVisitor == null) {
            return null;
        }
        return createAnnotationRemapper(annotationVisitor);
    }

    @Override // org.objectweb.asm.RecordComponentVisitor
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        AnnotationVisitor annotationVisitor = super.visitTypeAnnotation(typeRef, typePath, this.remapper.mapDesc(descriptor), visible);
        if (annotationVisitor == null) {
            return null;
        }
        return createAnnotationRemapper(annotationVisitor);
    }

    protected AnnotationVisitor createAnnotationRemapper(AnnotationVisitor annotationVisitor) {
        return new AnnotationRemapper(this.api, annotationVisitor, this.remapper);
    }
}
