package org.objectweb.asm;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/MethodVisitor.SCL.lombok */
public abstract class MethodVisitor {
    private static final String REQUIRES_ASM5 = "This feature requires ASM5";
    protected final int api;

    /* JADX INFO: renamed from: mv */
    protected MethodVisitor f27600mv;

    public MethodVisitor(int api) {
        this(api, null);
    }

    public MethodVisitor(int api, MethodVisitor methodVisitor) {
        if (api != 589824 && api != 524288 && api != 458752 && api != 393216 && api != 327680 && api != 262144 && api != 17432576) {
            throw new IllegalArgumentException("Unsupported api " + api);
        }
        if (api == 17432576) {
            Constants.checkAsmExperimental(this);
        }
        this.api = api;
        this.f27600mv = methodVisitor;
    }

    public void visitParameter(String name, int access) {
        if (this.api < 327680) {
            throw new UnsupportedOperationException(REQUIRES_ASM5);
        }
        if (this.f27600mv != null) {
            this.f27600mv.visitParameter(name, access);
        }
    }

    public AnnotationVisitor visitAnnotationDefault() {
        if (this.f27600mv != null) {
            return this.f27600mv.visitAnnotationDefault();
        }
        return null;
    }

    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        if (this.f27600mv != null) {
            return this.f27600mv.visitAnnotation(descriptor, visible);
        }
        return null;
    }

    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        if (this.api < 327680) {
            throw new UnsupportedOperationException(REQUIRES_ASM5);
        }
        if (this.f27600mv != null) {
            return this.f27600mv.visitTypeAnnotation(typeRef, typePath, descriptor, visible);
        }
        return null;
    }

    public void visitAnnotableParameterCount(int parameterCount, boolean visible) {
        if (this.f27600mv != null) {
            this.f27600mv.visitAnnotableParameterCount(parameterCount, visible);
        }
    }

    public AnnotationVisitor visitParameterAnnotation(int parameter, String descriptor, boolean visible) {
        if (this.f27600mv != null) {
            return this.f27600mv.visitParameterAnnotation(parameter, descriptor, visible);
        }
        return null;
    }

    public void visitAttribute(Attribute attribute) {
        if (this.f27600mv != null) {
            this.f27600mv.visitAttribute(attribute);
        }
    }

    public void visitCode() {
        if (this.f27600mv != null) {
            this.f27600mv.visitCode();
        }
    }

    public void visitFrame(int type, int numLocal, Object[] local, int numStack, Object[] stack) {
        if (this.f27600mv != null) {
            this.f27600mv.visitFrame(type, numLocal, local, numStack, stack);
        }
    }

    public void visitInsn(int opcode) {
        if (this.f27600mv != null) {
            this.f27600mv.visitInsn(opcode);
        }
    }

    public void visitIntInsn(int opcode, int operand) {
        if (this.f27600mv != null) {
            this.f27600mv.visitIntInsn(opcode, operand);
        }
    }

    public void visitVarInsn(int opcode, int var) {
        if (this.f27600mv != null) {
            this.f27600mv.visitVarInsn(opcode, var);
        }
    }

    public void visitTypeInsn(int opcode, String type) {
        if (this.f27600mv != null) {
            this.f27600mv.visitTypeInsn(opcode, type);
        }
    }

    public void visitFieldInsn(int opcode, String owner, String name, String descriptor) {
        if (this.f27600mv != null) {
            this.f27600mv.visitFieldInsn(opcode, owner, name, descriptor);
        }
    }

    @Deprecated
    public void visitMethodInsn(int opcode, String owner, String name, String descriptor) {
        int opcodeAndSource = opcode | (this.api < 327680 ? 256 : 0);
        visitMethodInsn(opcodeAndSource, owner, name, descriptor, opcode == 185);
    }

    public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
        if (this.api < 327680 && (opcode & 256) == 0) {
            if (isInterface != (opcode == 185)) {
                throw new UnsupportedOperationException("INVOKESPECIAL/STATIC on interfaces requires ASM5");
            }
            visitMethodInsn(opcode, owner, name, descriptor);
        } else if (this.f27600mv != null) {
            this.f27600mv.visitMethodInsn(opcode & (-257), owner, name, descriptor, isInterface);
        }
    }

    public void visitInvokeDynamicInsn(String name, String descriptor, Handle bootstrapMethodHandle, Object... bootstrapMethodArguments) {
        if (this.api < 327680) {
            throw new UnsupportedOperationException(REQUIRES_ASM5);
        }
        if (this.f27600mv != null) {
            this.f27600mv.visitInvokeDynamicInsn(name, descriptor, bootstrapMethodHandle, bootstrapMethodArguments);
        }
    }

    public void visitJumpInsn(int opcode, Label label) {
        if (this.f27600mv != null) {
            this.f27600mv.visitJumpInsn(opcode, label);
        }
    }

    public void visitLabel(Label label) {
        if (this.f27600mv != null) {
            this.f27600mv.visitLabel(label);
        }
    }

    public void visitLdcInsn(Object value) {
        if (this.api < 327680 && ((value instanceof Handle) || ((value instanceof Type) && ((Type) value).getSort() == 11))) {
            throw new UnsupportedOperationException(REQUIRES_ASM5);
        }
        if (this.api < 458752 && (value instanceof ConstantDynamic)) {
            throw new UnsupportedOperationException("This feature requires ASM7");
        }
        if (this.f27600mv != null) {
            this.f27600mv.visitLdcInsn(value);
        }
    }

    public void visitIincInsn(int var, int increment) {
        if (this.f27600mv != null) {
            this.f27600mv.visitIincInsn(var, increment);
        }
    }

    public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels) {
        if (this.f27600mv != null) {
            this.f27600mv.visitTableSwitchInsn(min, max, dflt, labels);
        }
    }

    public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
        if (this.f27600mv != null) {
            this.f27600mv.visitLookupSwitchInsn(dflt, keys, labels);
        }
    }

    public void visitMultiANewArrayInsn(String descriptor, int numDimensions) {
        if (this.f27600mv != null) {
            this.f27600mv.visitMultiANewArrayInsn(descriptor, numDimensions);
        }
    }

    public AnnotationVisitor visitInsnAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        if (this.api < 327680) {
            throw new UnsupportedOperationException(REQUIRES_ASM5);
        }
        if (this.f27600mv != null) {
            return this.f27600mv.visitInsnAnnotation(typeRef, typePath, descriptor, visible);
        }
        return null;
    }

    public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
        if (this.f27600mv != null) {
            this.f27600mv.visitTryCatchBlock(start, end, handler, type);
        }
    }

    public AnnotationVisitor visitTryCatchAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        if (this.api < 327680) {
            throw new UnsupportedOperationException(REQUIRES_ASM5);
        }
        if (this.f27600mv != null) {
            return this.f27600mv.visitTryCatchAnnotation(typeRef, typePath, descriptor, visible);
        }
        return null;
    }

    public void visitLocalVariable(String name, String descriptor, String signature, Label start, Label end, int index) {
        if (this.f27600mv != null) {
            this.f27600mv.visitLocalVariable(name, descriptor, signature, start, end, index);
        }
    }

    public AnnotationVisitor visitLocalVariableAnnotation(int typeRef, TypePath typePath, Label[] start, Label[] end, int[] index, String descriptor, boolean visible) {
        if (this.api < 327680) {
            throw new UnsupportedOperationException(REQUIRES_ASM5);
        }
        if (this.f27600mv != null) {
            return this.f27600mv.visitLocalVariableAnnotation(typeRef, typePath, start, end, index, descriptor, visible);
        }
        return null;
    }

    public void visitLineNumber(int line, Label start) {
        if (this.f27600mv != null) {
            this.f27600mv.visitLineNumber(line, start);
        }
    }

    public void visitMaxs(int maxStack, int maxLocals) {
        if (this.f27600mv != null) {
            this.f27600mv.visitMaxs(maxStack, maxLocals);
        }
    }

    public void visitEnd() {
        if (this.f27600mv != null) {
            this.f27600mv.visitEnd();
        }
    }
}
