package org.objectweb.asm.commons;

import java.util.List;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.ModuleVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.RecordComponentVisitor;
import org.objectweb.asm.TypePath;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/commons/ClassRemapper.SCL.lombok */
public class ClassRemapper extends ClassVisitor {
    protected final Remapper remapper;
    protected String className;

    public ClassRemapper(ClassVisitor classVisitor, Remapper remapper) {
        this(Opcodes.ASM9, classVisitor, remapper);
    }

    protected ClassRemapper(int api, ClassVisitor classVisitor, Remapper remapper) {
        super(api, classVisitor);
        this.remapper = remapper;
    }

    @Override // org.objectweb.asm.ClassVisitor
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        this.className = name;
        super.visit(version, access, this.remapper.mapType(name), this.remapper.mapSignature(signature, false), this.remapper.mapType(superName), interfaces == null ? null : this.remapper.mapTypes(interfaces));
    }

    @Override // org.objectweb.asm.ClassVisitor
    public ModuleVisitor visitModule(String name, int flags, String version) {
        ModuleVisitor moduleVisitor = super.visitModule(this.remapper.mapModuleName(name), flags, version);
        if (moduleVisitor == null) {
            return null;
        }
        return createModuleRemapper(moduleVisitor);
    }

    @Override // org.objectweb.asm.ClassVisitor
    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        AnnotationVisitor annotationVisitor = super.visitAnnotation(this.remapper.mapDesc(descriptor), visible);
        if (annotationVisitor == null) {
            return null;
        }
        return createAnnotationRemapper(annotationVisitor);
    }

    @Override // org.objectweb.asm.ClassVisitor
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        AnnotationVisitor annotationVisitor = super.visitTypeAnnotation(typeRef, typePath, this.remapper.mapDesc(descriptor), visible);
        if (annotationVisitor == null) {
            return null;
        }
        return createAnnotationRemapper(annotationVisitor);
    }

    @Override // org.objectweb.asm.ClassVisitor
    public void visitAttribute(Attribute attribute) {
        if (attribute instanceof ModuleHashesAttribute) {
            ModuleHashesAttribute moduleHashesAttribute = (ModuleHashesAttribute) attribute;
            List<String> modules = moduleHashesAttribute.modules;
            for (int i = 0; i < modules.size(); i++) {
                modules.set(i, this.remapper.mapModuleName(modules.get(i)));
            }
        }
        super.visitAttribute(attribute);
    }

    @Override // org.objectweb.asm.ClassVisitor
    public RecordComponentVisitor visitRecordComponent(String name, String descriptor, String signature) {
        RecordComponentVisitor recordComponentVisitor = super.visitRecordComponent(this.remapper.mapRecordComponentName(this.className, name, descriptor), this.remapper.mapDesc(descriptor), this.remapper.mapSignature(signature, true));
        if (recordComponentVisitor == null) {
            return null;
        }
        return createRecordComponentRemapper(recordComponentVisitor);
    }

    @Override // org.objectweb.asm.ClassVisitor
    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
        FieldVisitor fieldVisitor = super.visitField(access, this.remapper.mapFieldName(this.className, name, descriptor), this.remapper.mapDesc(descriptor), this.remapper.mapSignature(signature, true), value == null ? null : this.remapper.mapValue(value));
        if (fieldVisitor == null) {
            return null;
        }
        return createFieldRemapper(fieldVisitor);
    }

    @Override // org.objectweb.asm.ClassVisitor
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        String remappedDescriptor = this.remapper.mapMethodDesc(descriptor);
        MethodVisitor methodVisitor = super.visitMethod(access, this.remapper.mapMethodName(this.className, name, descriptor), remappedDescriptor, this.remapper.mapSignature(signature, false), exceptions == null ? null : this.remapper.mapTypes(exceptions));
        if (methodVisitor == null) {
            return null;
        }
        return createMethodRemapper(methodVisitor);
    }

    @Override // org.objectweb.asm.ClassVisitor
    public void visitInnerClass(String name, String outerName, String innerName, int access) {
        super.visitInnerClass(this.remapper.mapType(name), outerName == null ? null : this.remapper.mapType(outerName), innerName == null ? null : this.remapper.mapInnerClassName(name, outerName, innerName), access);
    }

    @Override // org.objectweb.asm.ClassVisitor
    public void visitOuterClass(String owner, String name, String descriptor) {
        super.visitOuterClass(this.remapper.mapType(owner), name == null ? null : this.remapper.mapMethodName(owner, name, descriptor), descriptor == null ? null : this.remapper.mapMethodDesc(descriptor));
    }

    @Override // org.objectweb.asm.ClassVisitor
    public void visitNestHost(String nestHost) {
        super.visitNestHost(this.remapper.mapType(nestHost));
    }

    @Override // org.objectweb.asm.ClassVisitor
    public void visitNestMember(String nestMember) {
        super.visitNestMember(this.remapper.mapType(nestMember));
    }

    @Override // org.objectweb.asm.ClassVisitor
    public void visitPermittedSubclass(String permittedSubclass) {
        super.visitPermittedSubclass(this.remapper.mapType(permittedSubclass));
    }

    protected FieldVisitor createFieldRemapper(FieldVisitor fieldVisitor) {
        return new FieldRemapper(this.api, fieldVisitor, this.remapper);
    }

    protected MethodVisitor createMethodRemapper(MethodVisitor methodVisitor) {
        return new MethodRemapper(this.api, methodVisitor, this.remapper);
    }

    protected AnnotationVisitor createAnnotationRemapper(AnnotationVisitor annotationVisitor) {
        return new AnnotationRemapper(this.api, annotationVisitor, this.remapper);
    }

    protected ModuleVisitor createModuleRemapper(ModuleVisitor moduleVisitor) {
        return new ModuleRemapper(this.api, moduleVisitor, this.remapper);
    }

    protected RecordComponentVisitor createRecordComponentRemapper(RecordComponentVisitor recordComponentVisitor) {
        return new RecordComponentRemapper(this.api, recordComponentVisitor, this.remapper);
    }
}
