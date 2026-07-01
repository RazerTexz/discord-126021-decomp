package org.objectweb.asm.tree.analysis;

import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.List;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

/* JADX INFO: loaded from: app.apk:org/objectweb/asm/tree/analysis/SimpleVerifier.SCL.lombok */
public class SimpleVerifier extends BasicVerifier {
    private final Type currentClass;
    private final Type currentSuperClass;
    private final List<Type> currentClassInterfaces;
    private final boolean isInterface;
    private ClassLoader loader;

    @Override // org.objectweb.asm.tree.analysis.BasicInterpreter, org.objectweb.asm.tree.analysis.Interpreter
    public /* bridge */ /* synthetic */ Value merge(Value value, Value value2) {
        return merge((BasicValue) value, (BasicValue) value2);
    }

    @Override // org.objectweb.asm.tree.analysis.BasicInterpreter, org.objectweb.asm.tree.analysis.Interpreter
    public /* bridge */ /* synthetic */ Value newValue(Type type) {
        return newValue(type);
    }

    public SimpleVerifier() {
        this(null, null, false);
    }

    public SimpleVerifier(Type currentClass, Type currentSuperClass, boolean isInterface) {
        this(currentClass, currentSuperClass, null, isInterface);
    }

    public SimpleVerifier(Type currentClass, Type currentSuperClass, List<Type> currentClassInterfaces, boolean isInterface) {
        this(Opcodes.ASM9, currentClass, currentSuperClass, currentClassInterfaces, isInterface);
        if (getClass() != SimpleVerifier.class) {
            throw new IllegalStateException();
        }
    }

    protected SimpleVerifier(int api, Type currentClass, Type currentSuperClass, List<Type> currentClassInterfaces, boolean isInterface) {
        super(api);
        this.loader = getClass().getClassLoader();
        this.currentClass = currentClass;
        this.currentSuperClass = currentSuperClass;
        this.currentClassInterfaces = currentClassInterfaces;
        this.isInterface = isInterface;
    }

    public void setClassLoader(ClassLoader loader) {
        this.loader = loader;
    }

    @Override // org.objectweb.asm.tree.analysis.BasicInterpreter, org.objectweb.asm.tree.analysis.Interpreter
    public BasicValue newValue(Type type) {
        if (type == null) {
            return BasicValue.UNINITIALIZED_VALUE;
        }
        boolean isArray = type.getSort() == 9;
        if (isArray) {
            switch (type.getElementType().getSort()) {
                case 1:
                case 2:
                case 3:
                case 4:
                    return new BasicValue(type);
            }
        }
        BasicValue value = super.newValue(type);
        if (BasicValue.REFERENCE_VALUE.equals(value)) {
            if (isArray) {
                BasicValue value2 = newValue(type.getElementType());
                StringBuilder descriptor = new StringBuilder();
                for (int i = 0; i < type.getDimensions(); i++) {
                    descriptor.append('[');
                }
                descriptor.append(value2.getType().getDescriptor());
                value = new BasicValue(Type.getType(descriptor.toString()));
            } else {
                value = new BasicValue(type);
            }
        }
        return value;
    }

    @Override // org.objectweb.asm.tree.analysis.BasicVerifier
    protected boolean isArrayValue(BasicValue value) {
        Type type = value.getType();
        return type != null && (type.getSort() == 9 || type.equals(NULL_TYPE));
    }

    @Override // org.objectweb.asm.tree.analysis.BasicVerifier
    protected BasicValue getElementValue(BasicValue objectArrayValue) throws AnalyzerException {
        Type arrayType = objectArrayValue.getType();
        if (arrayType != null) {
            if (arrayType.getSort() == 9) {
                return newValue(Type.getType(arrayType.getDescriptor().substring(1)));
            }
            if (arrayType.equals(NULL_TYPE)) {
                return objectArrayValue;
            }
        }
        throw new AssertionError();
    }

    @Override // org.objectweb.asm.tree.analysis.BasicVerifier
    protected boolean isSubTypeOf(BasicValue value, BasicValue expected) {
        Type expectedType = expected.getType();
        Type type = value.getType();
        switch (expectedType.getSort()) {
            case 5:
            case 6:
            case 7:
            case 8:
                return type.equals(expectedType);
            case 9:
            case 10:
                if (type.equals(NULL_TYPE)) {
                    return true;
                }
                if (type.getSort() == 10 || type.getSort() == 9) {
                    if (isAssignableFrom(expectedType, type)) {
                        return true;
                    }
                    if (getClass(expectedType).isInterface()) {
                        return Object.class.isAssignableFrom(getClass(type));
                    }
                    return false;
                }
                return false;
            default:
                throw new AssertionError();
        }
    }

    @Override // org.objectweb.asm.tree.analysis.BasicInterpreter
    public BasicValue merge(BasicValue value1, BasicValue value2) {
        if (!value1.equals(value2)) {
            Type type1 = value1.getType();
            Type type2 = value2.getType();
            if (type1 != null && ((type1.getSort() == 10 || type1.getSort() == 9) && type2 != null && (type2.getSort() == 10 || type2.getSort() == 9))) {
                if (type1.equals(NULL_TYPE)) {
                    return value2;
                }
                if (type2.equals(NULL_TYPE)) {
                    return value1;
                }
                if (isAssignableFrom(type1, type2)) {
                    return value1;
                }
                if (isAssignableFrom(type2, type1)) {
                    return value2;
                }
                int numDimensions = 0;
                if (type1.getSort() == 9 && type2.getSort() == 9 && type1.getDimensions() == type2.getDimensions() && type1.getElementType().getSort() == 10 && type2.getElementType().getSort() == 10) {
                    numDimensions = type1.getDimensions();
                    type1 = type1.getElementType();
                    type2 = type2.getElementType();
                }
                while (type1 != null && !isInterface(type1)) {
                    type1 = getSuperClass(type1);
                    if (isAssignableFrom(type1, type2)) {
                        return newArrayValue(type1, numDimensions);
                    }
                }
                return newArrayValue(Type.getObjectType("java/lang/Object"), numDimensions);
            }
            return BasicValue.UNINITIALIZED_VALUE;
        }
        return value1;
    }

    private BasicValue newArrayValue(Type type, int dimensions) {
        if (dimensions == 0) {
            return newValue(type);
        }
        StringBuilder descriptor = new StringBuilder();
        for (int i = 0; i < dimensions; i++) {
            descriptor.append('[');
        }
        descriptor.append(type.getDescriptor());
        return newValue(Type.getType(descriptor.toString()));
    }

    protected boolean isInterface(Type type) {
        if (this.currentClass != null && this.currentClass.equals(type)) {
            return this.isInterface;
        }
        return getClass(type).isInterface();
    }

    protected Type getSuperClass(Type type) {
        if (this.currentClass != null && this.currentClass.equals(type)) {
            return this.currentSuperClass;
        }
        Class<?> superClass = getClass(type).getSuperclass();
        if (superClass == null) {
            return null;
        }
        return Type.getType(superClass);
    }

    protected boolean isAssignableFrom(Type type1, Type type2) {
        if (type1.equals(type2)) {
            return true;
        }
        if (this.currentClass != null && this.currentClass.equals(type1)) {
            if (getSuperClass(type2) == null) {
                return false;
            }
            if (this.isInterface) {
                return type2.getSort() == 10 || type2.getSort() == 9;
            }
            return isAssignableFrom(type1, getSuperClass(type2));
        }
        if (this.currentClass != null && this.currentClass.equals(type2)) {
            if (isAssignableFrom(type1, this.currentSuperClass)) {
                return true;
            }
            if (this.currentClassInterfaces != null) {
                for (Type currentClassInterface : this.currentClassInterfaces) {
                    if (isAssignableFrom(type1, currentClassInterface)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return getClass(type1).isAssignableFrom(getClass(type2));
    }

    protected Class<?> getClass(Type type) {
        try {
            if (type.getSort() == 9) {
                return Class.forName(type.getDescriptor().replace(MentionUtilsKt.SLASH_CHAR, '.'), false, this.loader);
            }
            return Class.forName(type.getClassName(), false, this.loader);
        } catch (ClassNotFoundException e) {
            throw new TypeNotPresentException(e.toString(), e);
        }
    }
}
