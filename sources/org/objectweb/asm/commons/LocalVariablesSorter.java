package org.objectweb.asm.commons;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.TypePath;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/commons/LocalVariablesSorter.SCL.lombok */
public class LocalVariablesSorter extends MethodVisitor {
    private static final Type OBJECT_TYPE = Type.getObjectType("java/lang/Object");
    private int[] remappedVariableIndices;
    private Object[] remappedLocalTypes;
    protected final int firstLocal;
    protected int nextLocal;

    public LocalVariablesSorter(int access, String descriptor, MethodVisitor methodVisitor) {
        this(Opcodes.ASM9, access, descriptor, methodVisitor);
        if (getClass() != LocalVariablesSorter.class) {
            throw new IllegalStateException();
        }
    }

    protected LocalVariablesSorter(int api, int access, String descriptor, MethodVisitor methodVisitor) {
        super(api, methodVisitor);
        this.remappedVariableIndices = new int[40];
        this.remappedLocalTypes = new Object[20];
        this.nextLocal = (8 & access) == 0 ? 1 : 0;
        for (Type argumentType : Type.getArgumentTypes(descriptor)) {
            this.nextLocal += argumentType.getSize();
        }
        this.firstLocal = this.nextLocal;
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitVarInsn(int opcode, int var) {
        Type varType;
        switch (opcode) {
            case 21:
            case 54:
                varType = Type.INT_TYPE;
                break;
            case 22:
            case 55:
                varType = Type.LONG_TYPE;
                break;
            case 23:
            case 56:
                varType = Type.FLOAT_TYPE;
                break;
            case 24:
            case 57:
                varType = Type.DOUBLE_TYPE;
                break;
            case 25:
            case 58:
            case Opcodes.RET /* 169 */:
                varType = OBJECT_TYPE;
                break;
            default:
                throw new IllegalArgumentException("Invalid opcode " + opcode);
        }
        super.visitVarInsn(opcode, remap(var, varType));
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitIincInsn(int var, int increment) {
        super.visitIincInsn(remap(var, Type.INT_TYPE), increment);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitMaxs(int maxStack, int maxLocals) {
        super.visitMaxs(maxStack, this.nextLocal);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitLocalVariable(String name, String descriptor, String signature, Label start, Label end, int index) {
        int remappedIndex = remap(index, Type.getType(descriptor));
        super.visitLocalVariable(name, descriptor, signature, start, end, remappedIndex);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public AnnotationVisitor visitLocalVariableAnnotation(int typeRef, TypePath typePath, Label[] start, Label[] end, int[] index, String descriptor, boolean visible) {
        Type type = Type.getType(descriptor);
        int[] remappedIndex = new int[index.length];
        for (int i = 0; i < remappedIndex.length; i++) {
            remappedIndex[i] = remap(index[i], type);
        }
        return super.visitLocalVariableAnnotation(typeRef, typePath, start, end, remappedIndex, descriptor, visible);
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitFrame(int type, int numLocal, Object[] local, int numStack, Object[] stack) {
        if (type != -1) {
            throw new IllegalArgumentException("LocalVariablesSorter only accepts expanded frames (see ClassReader.EXPAND_FRAMES)");
        }
        Object[] oldRemappedLocals = new Object[this.remappedLocalTypes.length];
        System.arraycopy(this.remappedLocalTypes, 0, oldRemappedLocals, 0, oldRemappedLocals.length);
        updateNewLocals(this.remappedLocalTypes);
        int oldVar = 0;
        for (int i = 0; i < numLocal; i++) {
            Object localType = local[i];
            if (localType != Opcodes.TOP) {
                Type varType = OBJECT_TYPE;
                if (localType == Opcodes.INTEGER) {
                    varType = Type.INT_TYPE;
                } else if (localType == Opcodes.FLOAT) {
                    varType = Type.FLOAT_TYPE;
                } else if (localType == Opcodes.LONG) {
                    varType = Type.LONG_TYPE;
                } else if (localType == Opcodes.DOUBLE) {
                    varType = Type.DOUBLE_TYPE;
                } else if (localType instanceof String) {
                    varType = Type.getObjectType((String) localType);
                }
                setFrameLocal(remap(oldVar, varType), localType);
            }
            oldVar += (localType == Opcodes.LONG || localType == Opcodes.DOUBLE) ? 2 : 1;
        }
        int oldVar2 = 0;
        int newVar = 0;
        int remappedNumLocal = 0;
        while (oldVar2 < this.remappedLocalTypes.length) {
            Object localType2 = this.remappedLocalTypes[oldVar2];
            oldVar2 += (localType2 == Opcodes.LONG || localType2 == Opcodes.DOUBLE) ? 2 : 1;
            if (localType2 != null && localType2 != Opcodes.TOP) {
                int i2 = newVar;
                newVar++;
                this.remappedLocalTypes[i2] = localType2;
                remappedNumLocal = newVar;
            } else {
                int i3 = newVar;
                newVar++;
                this.remappedLocalTypes[i3] = Opcodes.TOP;
            }
        }
        super.visitFrame(type, remappedNumLocal, this.remappedLocalTypes, numStack, stack);
        this.remappedLocalTypes = oldRemappedLocals;
    }

    public int newLocal(Type type) {
        Object localType;
        switch (type.getSort()) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                localType = Opcodes.INTEGER;
                break;
            case 6:
                localType = Opcodes.FLOAT;
                break;
            case 7:
                localType = Opcodes.LONG;
                break;
            case 8:
                localType = Opcodes.DOUBLE;
                break;
            case 9:
                localType = type.getDescriptor();
                break;
            case 10:
                localType = type.getInternalName();
                break;
            default:
                throw new AssertionError();
        }
        int local = newLocalMapping(type);
        setLocalType(local, type);
        setFrameLocal(local, localType);
        return local;
    }

    protected void updateNewLocals(Object[] newLocals) {
    }

    protected void setLocalType(int local, Type type) {
    }

    private void setFrameLocal(int local, Object type) {
        int numLocals = this.remappedLocalTypes.length;
        if (local >= numLocals) {
            Object[] newRemappedLocalTypes = new Object[Math.max(2 * numLocals, local + 1)];
            System.arraycopy(this.remappedLocalTypes, 0, newRemappedLocalTypes, 0, numLocals);
            this.remappedLocalTypes = newRemappedLocalTypes;
        }
        this.remappedLocalTypes[local] = type;
    }

    private int remap(int var, Type type) {
        int value;
        if (var + type.getSize() <= this.firstLocal) {
            return var;
        }
        int key = ((2 * var) + type.getSize()) - 1;
        int size = this.remappedVariableIndices.length;
        if (key >= size) {
            int[] newRemappedVariableIndices = new int[Math.max(2 * size, key + 1)];
            System.arraycopy(this.remappedVariableIndices, 0, newRemappedVariableIndices, 0, size);
            this.remappedVariableIndices = newRemappedVariableIndices;
        }
        int value2 = this.remappedVariableIndices[key];
        if (value2 == 0) {
            value = newLocalMapping(type);
            setLocalType(value, type);
            this.remappedVariableIndices[key] = value + 1;
        } else {
            value = value2 - 1;
        }
        return value;
    }

    protected int newLocalMapping(Type type) {
        int local = this.nextLocal;
        this.nextLocal += type.getSize();
        return local;
    }
}
