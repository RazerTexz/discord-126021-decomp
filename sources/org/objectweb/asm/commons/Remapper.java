package org.objectweb.asm.commons;

import org.objectweb.asm.ConstantDynamic;
import org.objectweb.asm.Handle;
import org.objectweb.asm.Type;
import org.objectweb.asm.signature.SignatureReader;
import org.objectweb.asm.signature.SignatureVisitor;
import org.objectweb.asm.signature.SignatureWriter;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/commons/Remapper.SCL.lombok */
public abstract class Remapper {
    public String mapDesc(String descriptor) {
        return mapType(Type.getType(descriptor)).getDescriptor();
    }

    private Type mapType(Type type) {
        switch (type.getSort()) {
            case 9:
                StringBuilder remappedDescriptor = new StringBuilder();
                for (int i = 0; i < type.getDimensions(); i++) {
                    remappedDescriptor.append('[');
                }
                remappedDescriptor.append(mapType(type.getElementType()).getDescriptor());
                return Type.getType(remappedDescriptor.toString());
            case 10:
                String remappedInternalName = map(type.getInternalName());
                return remappedInternalName != null ? Type.getObjectType(remappedInternalName) : type;
            case 11:
                return Type.getMethodType(mapMethodDesc(type.getDescriptor()));
            default:
                return type;
        }
    }

    public String mapType(String internalName) {
        if (internalName == null) {
            return null;
        }
        return mapType(Type.getObjectType(internalName)).getInternalName();
    }

    public String[] mapTypes(String[] internalNames) {
        String[] remappedInternalNames = null;
        for (int i = 0; i < internalNames.length; i++) {
            String internalName = internalNames[i];
            String remappedInternalName = mapType(internalName);
            if (remappedInternalName != null) {
                if (remappedInternalNames == null) {
                    remappedInternalNames = (String[]) internalNames.clone();
                }
                remappedInternalNames[i] = remappedInternalName;
            }
        }
        return remappedInternalNames != null ? remappedInternalNames : internalNames;
    }

    public String mapMethodDesc(String methodDescriptor) {
        if ("()V".equals(methodDescriptor)) {
            return methodDescriptor;
        }
        StringBuilder stringBuilder = new StringBuilder("(");
        for (Type argumentType : Type.getArgumentTypes(methodDescriptor)) {
            stringBuilder.append(mapType(argumentType).getDescriptor());
        }
        Type returnType = Type.getReturnType(methodDescriptor);
        if (returnType == Type.VOID_TYPE) {
            stringBuilder.append(")V");
        } else {
            stringBuilder.append(')').append(mapType(returnType).getDescriptor());
        }
        return stringBuilder.toString();
    }

    public Object mapValue(Object value) {
        String strMapMethodDesc;
        if (value instanceof Type) {
            return mapType((Type) value);
        }
        if (value instanceof Handle) {
            Handle handle = (Handle) value;
            int tag = handle.getTag();
            String strMapType = mapType(handle.getOwner());
            String strMapMethodName = mapMethodName(handle.getOwner(), handle.getName(), handle.getDesc());
            if (handle.getTag() <= 4) {
                strMapMethodDesc = mapDesc(handle.getDesc());
            } else {
                strMapMethodDesc = mapMethodDesc(handle.getDesc());
            }
            return new Handle(tag, strMapType, strMapMethodName, strMapMethodDesc, handle.isInterface());
        }
        if (value instanceof ConstantDynamic) {
            ConstantDynamic constantDynamic = (ConstantDynamic) value;
            int bootstrapMethodArgumentCount = constantDynamic.getBootstrapMethodArgumentCount();
            Object[] remappedBootstrapMethodArguments = new Object[bootstrapMethodArgumentCount];
            for (int i = 0; i < bootstrapMethodArgumentCount; i++) {
                remappedBootstrapMethodArguments[i] = mapValue(constantDynamic.getBootstrapMethodArgument(i));
            }
            String descriptor = constantDynamic.getDescriptor();
            return new ConstantDynamic(mapInvokeDynamicMethodName(constantDynamic.getName(), descriptor), mapDesc(descriptor), (Handle) mapValue(constantDynamic.getBootstrapMethod()), remappedBootstrapMethodArguments);
        }
        return value;
    }

    public String mapSignature(String signature, boolean typeSignature) {
        if (signature == null) {
            return null;
        }
        SignatureReader signatureReader = new SignatureReader(signature);
        SignatureWriter signatureWriter = new SignatureWriter();
        SignatureVisitor signatureRemapper = createSignatureRemapper(signatureWriter);
        if (typeSignature) {
            signatureReader.acceptType(signatureRemapper);
        } else {
            signatureReader.accept(signatureRemapper);
        }
        return signatureWriter.toString();
    }

    @Deprecated
    protected SignatureVisitor createRemappingSignatureAdapter(SignatureVisitor signatureVisitor) {
        return createSignatureRemapper(signatureVisitor);
    }

    protected SignatureVisitor createSignatureRemapper(SignatureVisitor signatureVisitor) {
        return new SignatureRemapper(signatureVisitor, this);
    }

    public String mapInnerClassName(String name, String ownerName, String innerName) {
        String remappedInnerName = mapType(name);
        if (remappedInnerName.contains("$")) {
            int index = remappedInnerName.lastIndexOf(36) + 1;
            while (index < remappedInnerName.length() && Character.isDigit(remappedInnerName.charAt(index))) {
                index++;
            }
            return remappedInnerName.substring(index);
        }
        return innerName;
    }

    public String mapMethodName(String owner, String name, String descriptor) {
        return name;
    }

    public String mapInvokeDynamicMethodName(String name, String descriptor) {
        return name;
    }

    public String mapRecordComponentName(String owner, String name, String descriptor) {
        return name;
    }

    public String mapFieldName(String owner, String name, String descriptor) {
        return name;
    }

    public String mapPackageName(String name) {
        return name;
    }

    public String mapModuleName(String name) {
        return name;
    }

    public String map(String internalName) {
        return internalName;
    }
}
