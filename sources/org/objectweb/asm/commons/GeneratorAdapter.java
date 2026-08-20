package org.objectweb.asm.commons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ConstantDynamic;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/commons/GeneratorAdapter.SCL.lombok */
public class GeneratorAdapter extends LocalVariablesSorter {
    private static final String CLASS_DESCRIPTOR = "Ljava/lang/Class;";
    private static final Type BYTE_TYPE = Type.getObjectType("java/lang/Byte");
    private static final Type BOOLEAN_TYPE = Type.getObjectType("java/lang/Boolean");
    private static final Type SHORT_TYPE = Type.getObjectType("java/lang/Short");
    private static final Type CHARACTER_TYPE = Type.getObjectType("java/lang/Character");
    private static final Type INTEGER_TYPE = Type.getObjectType("java/lang/Integer");
    private static final Type FLOAT_TYPE = Type.getObjectType("java/lang/Float");
    private static final Type LONG_TYPE = Type.getObjectType("java/lang/Long");
    private static final Type DOUBLE_TYPE = Type.getObjectType("java/lang/Double");
    private static final Type NUMBER_TYPE = Type.getObjectType("java/lang/Number");
    private static final Type OBJECT_TYPE = Type.getObjectType("java/lang/Object");
    private static final Method BOOLEAN_VALUE = Method.getMethod("boolean booleanValue()");
    private static final Method CHAR_VALUE = Method.getMethod("char charValue()");
    private static final Method INT_VALUE = Method.getMethod("int intValue()");
    private static final Method FLOAT_VALUE = Method.getMethod("float floatValue()");
    private static final Method LONG_VALUE = Method.getMethod("long longValue()");
    private static final Method DOUBLE_VALUE = Method.getMethod("double doubleValue()");
    public static final int ADD = 96;
    public static final int SUB = 100;
    public static final int MUL = 104;
    public static final int DIV = 108;
    public static final int REM = 112;
    public static final int NEG = 116;
    public static final int SHL = 120;
    public static final int SHR = 122;
    public static final int USHR = 124;
    public static final int AND = 126;

    /* JADX INFO: renamed from: OR */
    public static final int f27604OR = 128;
    public static final int XOR = 130;

    /* JADX INFO: renamed from: EQ */
    public static final int f27605EQ = 153;

    /* JADX INFO: renamed from: NE */
    public static final int f27606NE = 154;

    /* JADX INFO: renamed from: LT */
    public static final int f27607LT = 155;

    /* JADX INFO: renamed from: GE */
    public static final int f27608GE = 156;

    /* JADX INFO: renamed from: GT */
    public static final int f27609GT = 157;

    /* JADX INFO: renamed from: LE */
    public static final int f27610LE = 158;
    private final int access;
    private final String name;
    private final Type returnType;
    private final Type[] argumentTypes;
    private final List<Type> localTypes;

    public GeneratorAdapter(MethodVisitor methodVisitor, int access, String name, String descriptor) {
        this(Opcodes.ASM9, methodVisitor, access, name, descriptor);
        if (getClass() != GeneratorAdapter.class) {
            throw new IllegalStateException();
        }
    }

    protected GeneratorAdapter(int api, MethodVisitor methodVisitor, int access, String name, String descriptor) {
        super(api, access, descriptor, methodVisitor);
        this.localTypes = new ArrayList();
        this.access = access;
        this.name = name;
        this.returnType = Type.getReturnType(descriptor);
        this.argumentTypes = Type.getArgumentTypes(descriptor);
    }

    public GeneratorAdapter(int access, Method method, MethodVisitor methodVisitor) {
        this(methodVisitor, access, method.getName(), method.getDescriptor());
    }

    public GeneratorAdapter(int access, Method method, String signature, Type[] exceptions, ClassVisitor classVisitor) {
        this(access, method, classVisitor.visitMethod(access, method.getName(), method.getDescriptor(), signature, exceptions == null ? null : getInternalNames(exceptions)));
    }

    private static String[] getInternalNames(Type[] types) {
        String[] names = new String[types.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = types[i].getInternalName();
        }
        return names;
    }

    public int getAccess() {
        return this.access;
    }

    public String getName() {
        return this.name;
    }

    public Type getReturnType() {
        return this.returnType;
    }

    public Type[] getArgumentTypes() {
        return (Type[]) this.argumentTypes.clone();
    }

    public void push(boolean value) {
        push(value ? 1 : 0);
    }

    public void push(int value) {
        if (value >= -1 && value <= 5) {
            this.f27600mv.visitInsn(3 + value);
            return;
        }
        if (value >= -128 && value <= 127) {
            this.f27600mv.visitIntInsn(16, value);
        } else if (value >= -32768 && value <= 32767) {
            this.f27600mv.visitIntInsn(17, value);
        } else {
            this.f27600mv.visitLdcInsn(Integer.valueOf(value));
        }
    }

    public void push(long value) {
        if (value == 0 || value == 1) {
            this.f27600mv.visitInsn(9 + ((int) value));
        } else {
            this.f27600mv.visitLdcInsn(Long.valueOf(value));
        }
    }

    public void push(float value) {
        int bits = Float.floatToIntBits(value);
        if (bits == 0 || bits == 1065353216 || bits == 1073741824) {
            this.f27600mv.visitInsn(11 + ((int) value));
        } else {
            this.f27600mv.visitLdcInsn(Float.valueOf(value));
        }
    }

    public void push(double value) {
        long bits = Double.doubleToLongBits(value);
        if (bits == 0 || bits == 4607182418800017408L) {
            this.f27600mv.visitInsn(14 + ((int) value));
        } else {
            this.f27600mv.visitLdcInsn(Double.valueOf(value));
        }
    }

    public void push(String value) {
        if (value == null) {
            this.f27600mv.visitInsn(1);
        } else {
            this.f27600mv.visitLdcInsn(value);
        }
    }

    public void push(Type value) {
        if (value == null) {
            this.f27600mv.visitInsn(1);
            return;
        }
        switch (value.getSort()) {
            case 1:
                this.f27600mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/Boolean", "TYPE", CLASS_DESCRIPTOR);
                break;
            case 2:
                this.f27600mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/Character", "TYPE", CLASS_DESCRIPTOR);
                break;
            case 3:
                this.f27600mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/Byte", "TYPE", CLASS_DESCRIPTOR);
                break;
            case 4:
                this.f27600mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/Short", "TYPE", CLASS_DESCRIPTOR);
                break;
            case 5:
                this.f27600mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/Integer", "TYPE", CLASS_DESCRIPTOR);
                break;
            case 6:
                this.f27600mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/Float", "TYPE", CLASS_DESCRIPTOR);
                break;
            case 7:
                this.f27600mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/Long", "TYPE", CLASS_DESCRIPTOR);
                break;
            case 8:
                this.f27600mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/Double", "TYPE", CLASS_DESCRIPTOR);
                break;
            default:
                this.f27600mv.visitLdcInsn(value);
                break;
        }
    }

    public void push(Handle handle) {
        if (handle == null) {
            this.f27600mv.visitInsn(1);
        } else {
            this.f27600mv.visitLdcInsn(handle);
        }
    }

    public void push(ConstantDynamic constantDynamic) {
        if (constantDynamic == null) {
            this.f27600mv.visitInsn(1);
        } else {
            this.f27600mv.visitLdcInsn(constantDynamic);
        }
    }

    private int getArgIndex(int arg) {
        int index = (this.access & 8) == 0 ? 1 : 0;
        for (int i = 0; i < arg; i++) {
            index += this.argumentTypes[i].getSize();
        }
        return index;
    }

    private void loadInsn(Type type, int index) {
        this.f27600mv.visitVarInsn(type.getOpcode(21), index);
    }

    private void storeInsn(Type type, int index) {
        this.f27600mv.visitVarInsn(type.getOpcode(54), index);
    }

    public void loadThis() {
        if ((this.access & 8) != 0) {
            throw new IllegalStateException("no 'this' pointer within static method");
        }
        this.f27600mv.visitVarInsn(25, 0);
    }

    public void loadArg(int arg) {
        loadInsn(this.argumentTypes[arg], getArgIndex(arg));
    }

    public void loadArgs(int arg, int count) {
        int index = getArgIndex(arg);
        for (int i = 0; i < count; i++) {
            Type argumentType = this.argumentTypes[arg + i];
            loadInsn(argumentType, index);
            index += argumentType.getSize();
        }
    }

    public void loadArgs() {
        loadArgs(0, this.argumentTypes.length);
    }

    public void loadArgArray() {
        push(this.argumentTypes.length);
        newArray(OBJECT_TYPE);
        for (int i = 0; i < this.argumentTypes.length; i++) {
            dup();
            push(i);
            loadArg(i);
            box(this.argumentTypes[i]);
            arrayStore(OBJECT_TYPE);
        }
    }

    public void storeArg(int arg) {
        storeInsn(this.argumentTypes[arg], getArgIndex(arg));
    }

    public Type getLocalType(int local) {
        return this.localTypes.get(local - this.firstLocal);
    }

    @Override // org.objectweb.asm.commons.LocalVariablesSorter
    protected void setLocalType(int local, Type type) {
        int index = local - this.firstLocal;
        while (this.localTypes.size() < index + 1) {
            this.localTypes.add(null);
        }
        this.localTypes.set(index, type);
    }

    public void loadLocal(int local) {
        loadInsn(getLocalType(local), local);
    }

    public void loadLocal(int local, Type type) {
        setLocalType(local, type);
        loadInsn(type, local);
    }

    public void storeLocal(int local) {
        storeInsn(getLocalType(local), local);
    }

    public void storeLocal(int local, Type type) {
        setLocalType(local, type);
        storeInsn(type, local);
    }

    public void arrayLoad(Type type) {
        this.f27600mv.visitInsn(type.getOpcode(46));
    }

    public void arrayStore(Type type) {
        this.f27600mv.visitInsn(type.getOpcode(79));
    }

    public void pop() {
        this.f27600mv.visitInsn(87);
    }

    public void pop2() {
        this.f27600mv.visitInsn(88);
    }

    public void dup() {
        this.f27600mv.visitInsn(89);
    }

    public void dup2() {
        this.f27600mv.visitInsn(92);
    }

    public void dupX1() {
        this.f27600mv.visitInsn(90);
    }

    public void dupX2() {
        this.f27600mv.visitInsn(91);
    }

    public void dup2X1() {
        this.f27600mv.visitInsn(93);
    }

    public void dup2X2() {
        this.f27600mv.visitInsn(94);
    }

    public void swap() {
        this.f27600mv.visitInsn(95);
    }

    public void swap(Type prev, Type type) {
        if (type.getSize() == 1) {
            if (prev.getSize() == 1) {
                swap();
                return;
            } else {
                dupX2();
                pop();
                return;
            }
        }
        if (prev.getSize() == 1) {
            dup2X1();
            pop2();
        } else {
            dup2X2();
            pop2();
        }
    }

    public void math(int op, Type type) {
        this.f27600mv.visitInsn(type.getOpcode(op));
    }

    public void not() {
        this.f27600mv.visitInsn(4);
        this.f27600mv.visitInsn(130);
    }

    public void iinc(int local, int amount) {
        this.f27600mv.visitIincInsn(local, amount);
    }

    public void cast(Type from, Type to) {
        if (from != to) {
            if (from.getSort() < 1 || from.getSort() > 8 || to.getSort() < 1 || to.getSort() > 8) {
                throw new IllegalArgumentException("Cannot cast from " + from + " to " + to);
            }
            InstructionAdapter.cast(this.f27600mv, from, to);
        }
    }

    private static Type getBoxedType(Type type) {
        switch (type.getSort()) {
            case 1:
                return BOOLEAN_TYPE;
            case 2:
                return CHARACTER_TYPE;
            case 3:
                return BYTE_TYPE;
            case 4:
                return SHORT_TYPE;
            case 5:
                return INTEGER_TYPE;
            case 6:
                return FLOAT_TYPE;
            case 7:
                return LONG_TYPE;
            case 8:
                return DOUBLE_TYPE;
            default:
                return type;
        }
    }

    public void box(Type type) {
        if (type.getSort() == 10 || type.getSort() == 9) {
            return;
        }
        if (type == Type.VOID_TYPE) {
            push((String) null);
            return;
        }
        Type boxedType = getBoxedType(type);
        newInstance(boxedType);
        if (type.getSize() == 2) {
            dupX2();
            dupX2();
            pop();
        } else {
            dupX1();
            swap();
        }
        invokeConstructor(boxedType, new Method("<init>", Type.VOID_TYPE, new Type[]{type}));
    }

    public void valueOf(Type type) {
        if (type.getSort() == 10 || type.getSort() == 9) {
            return;
        }
        if (type == Type.VOID_TYPE) {
            push((String) null);
        } else {
            Type boxedType = getBoxedType(type);
            invokeStatic(boxedType, new Method("valueOf", boxedType, new Type[]{type}));
        }
    }

    public void unbox(Type type) {
        Method unboxMethod;
        Type boxedType = NUMBER_TYPE;
        switch (type.getSort()) {
            case 0:
                return;
            case 1:
                boxedType = BOOLEAN_TYPE;
                unboxMethod = BOOLEAN_VALUE;
                break;
            case 2:
                boxedType = CHARACTER_TYPE;
                unboxMethod = CHAR_VALUE;
                break;
            case 3:
            case 4:
            case 5:
                unboxMethod = INT_VALUE;
                break;
            case 6:
                unboxMethod = FLOAT_VALUE;
                break;
            case 7:
                unboxMethod = LONG_VALUE;
                break;
            case 8:
                unboxMethod = DOUBLE_VALUE;
                break;
            default:
                unboxMethod = null;
                break;
        }
        if (unboxMethod == null) {
            checkCast(type);
        } else {
            checkCast(boxedType);
            invokeVirtual(boxedType, unboxMethod);
        }
    }

    public Label newLabel() {
        return new Label();
    }

    public void mark(Label label) {
        this.f27600mv.visitLabel(label);
    }

    public Label mark() {
        Label label = new Label();
        this.f27600mv.visitLabel(label);
        return label;
    }

    public void ifCmp(Type type, int mode, Label label) {
        int intOp;
        switch (type.getSort()) {
            case 6:
                this.f27600mv.visitInsn((mode == 156 || mode == 157) ? Opcodes.FCMPL : 150);
                break;
            case 7:
                this.f27600mv.visitInsn(Opcodes.LCMP);
                break;
            case 8:
                this.f27600mv.visitInsn((mode == 156 || mode == 157) ? Opcodes.DCMPL : Opcodes.DCMPG);
                break;
            case 9:
            case 10:
                if (mode == 153) {
                    this.f27600mv.visitJumpInsn(Opcodes.IF_ACMPEQ, label);
                    return;
                } else {
                    if (mode == 154) {
                        this.f27600mv.visitJumpInsn(Opcodes.IF_ACMPNE, label);
                        return;
                    }
                    throw new IllegalArgumentException("Bad comparison for type " + type);
                }
            default:
                switch (mode) {
                    case 153:
                        intOp = 159;
                        break;
                    case 154:
                        intOp = 160;
                        break;
                    case 155:
                        intOp = 161;
                        break;
                    case 156:
                        intOp = 162;
                        break;
                    case 157:
                        intOp = 163;
                        break;
                    case 158:
                        intOp = 164;
                        break;
                    default:
                        throw new IllegalArgumentException("Bad comparison mode " + mode);
                }
                this.f27600mv.visitJumpInsn(intOp, label);
                return;
        }
        this.f27600mv.visitJumpInsn(mode, label);
    }

    public void ifICmp(int mode, Label label) {
        ifCmp(Type.INT_TYPE, mode, label);
    }

    public void ifZCmp(int mode, Label label) {
        this.f27600mv.visitJumpInsn(mode, label);
    }

    public void ifNull(Label label) {
        this.f27600mv.visitJumpInsn(Opcodes.IFNULL, label);
    }

    public void ifNonNull(Label label) {
        this.f27600mv.visitJumpInsn(Opcodes.IFNONNULL, label);
    }

    public void goTo(Label label) {
        this.f27600mv.visitJumpInsn(Opcodes.GOTO, label);
    }

    public void ret(int local) {
        this.f27600mv.visitVarInsn(Opcodes.RET, local);
    }

    public void tableSwitch(int[] keys, TableSwitchGenerator generator) {
        float density;
        if (keys.length == 0) {
            density = 0.0f;
        } else {
            density = keys.length / ((keys[keys.length - 1] - keys[0]) + 1);
        }
        tableSwitch(keys, generator, density >= 0.5f);
    }

    public void tableSwitch(int[] keys, TableSwitchGenerator generator, boolean useTable) {
        for (int i = 1; i < keys.length; i++) {
            if (keys[i] < keys[i - 1]) {
                throw new IllegalArgumentException("keys must be sorted in ascending order");
            }
        }
        Label defaultLabel = newLabel();
        Label endLabel = newLabel();
        if (keys.length > 0) {
            int numKeys = keys.length;
            if (useTable) {
                int min = keys[0];
                int max = keys[numKeys - 1];
                int range = (max - min) + 1;
                Label[] labels = new Label[range];
                Arrays.fill(labels, defaultLabel);
                for (int i2 : keys) {
                    labels[i2 - min] = newLabel();
                }
                this.f27600mv.visitTableSwitchInsn(min, max, defaultLabel, labels);
                for (int i3 = 0; i3 < range; i3++) {
                    Label label = labels[i3];
                    if (label != defaultLabel) {
                        mark(label);
                        generator.generateCase(i3 + min, endLabel);
                    }
                }
            } else {
                Label[] labels2 = new Label[numKeys];
                for (int i4 = 0; i4 < numKeys; i4++) {
                    labels2[i4] = newLabel();
                }
                this.f27600mv.visitLookupSwitchInsn(defaultLabel, keys, labels2);
                for (int i5 = 0; i5 < numKeys; i5++) {
                    mark(labels2[i5]);
                    generator.generateCase(keys[i5], endLabel);
                }
            }
        }
        mark(defaultLabel);
        generator.generateDefault();
        mark(endLabel);
    }

    public void returnValue() {
        this.f27600mv.visitInsn(this.returnType.getOpcode(Opcodes.IRETURN));
    }

    private void fieldInsn(int opcode, Type ownerType, String name, Type fieldType) {
        this.f27600mv.visitFieldInsn(opcode, ownerType.getInternalName(), name, fieldType.getDescriptor());
    }

    public void getStatic(Type owner, String name, Type type) {
        fieldInsn(Opcodes.GETSTATIC, owner, name, type);
    }

    public void putStatic(Type owner, String name, Type type) {
        fieldInsn(Opcodes.PUTSTATIC, owner, name, type);
    }

    public void getField(Type owner, String name, Type type) {
        fieldInsn(180, owner, name, type);
    }

    public void putField(Type owner, String name, Type type) {
        fieldInsn(Opcodes.PUTFIELD, owner, name, type);
    }

    private void invokeInsn(int opcode, Type type, Method method, boolean isInterface) {
        String owner = type.getSort() == 9 ? type.getDescriptor() : type.getInternalName();
        this.f27600mv.visitMethodInsn(opcode, owner, method.getName(), method.getDescriptor(), isInterface);
    }

    public void invokeVirtual(Type owner, Method method) {
        invokeInsn(Opcodes.INVOKEVIRTUAL, owner, method, false);
    }

    public void invokeConstructor(Type type, Method method) {
        invokeInsn(Opcodes.INVOKESPECIAL, type, method, false);
    }

    public void invokeStatic(Type owner, Method method) {
        invokeInsn(Opcodes.INVOKESTATIC, owner, method, false);
    }

    public void invokeInterface(Type owner, Method method) {
        invokeInsn(Opcodes.INVOKEINTERFACE, owner, method, true);
    }

    public void invokeDynamic(String name, String descriptor, Handle bootstrapMethodHandle, Object... bootstrapMethodArguments) {
        this.f27600mv.visitInvokeDynamicInsn(name, descriptor, bootstrapMethodHandle, bootstrapMethodArguments);
    }

    private void typeInsn(int opcode, Type type) {
        this.f27600mv.visitTypeInsn(opcode, type.getInternalName());
    }

    public void newInstance(Type type) {
        typeInsn(Opcodes.NEW, type);
    }

    public void newArray(Type type) {
        InstructionAdapter.newarray(this.f27600mv, type);
    }

    public void arrayLength() {
        this.f27600mv.visitInsn(Opcodes.ARRAYLENGTH);
    }

    public void throwException() {
        this.f27600mv.visitInsn(Opcodes.ATHROW);
    }

    public void throwException(Type type, String message) {
        newInstance(type);
        dup();
        push(message);
        invokeConstructor(type, Method.getMethod("void <init> (String)"));
        throwException();
    }

    public void checkCast(Type type) {
        if (!type.equals(OBJECT_TYPE)) {
            typeInsn(Opcodes.CHECKCAST, type);
        }
    }

    public void instanceOf(Type type) {
        typeInsn(Opcodes.INSTANCEOF, type);
    }

    public void monitorEnter() {
        this.f27600mv.visitInsn(Opcodes.MONITORENTER);
    }

    public void monitorExit() {
        this.f27600mv.visitInsn(Opcodes.MONITOREXIT);
    }

    public void endMethod() {
        if ((this.access & 1024) == 0) {
            this.f27600mv.visitMaxs(0, 0);
        }
        this.f27600mv.visitEnd();
    }

    public void catchException(Label start, Label end, Type exception) {
        Label catchLabel = new Label();
        if (exception == null) {
            this.f27600mv.visitTryCatchBlock(start, end, catchLabel, null);
        } else {
            this.f27600mv.visitTryCatchBlock(start, end, catchLabel, exception.getInternalName());
        }
        mark(catchLabel);
    }
}
