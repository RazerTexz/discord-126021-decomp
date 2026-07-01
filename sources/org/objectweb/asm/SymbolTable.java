package org.objectweb.asm;

/* JADX INFO: loaded from: app.apk:org/objectweb/asm/SymbolTable.SCL.lombok */
final class SymbolTable {
    final ClassWriter classWriter;
    private final ClassReader sourceClassReader;
    private int majorVersion;
    private String className;
    private int entryCount;
    private SymbolTable$Entry[] entries;
    private int constantPoolCount;
    private ByteVector constantPool;
    private int bootstrapMethodCount;
    private ByteVector bootstrapMethods;
    private int typeCount;
    private SymbolTable$Entry[] typeTable;

    SymbolTable(ClassWriter classWriter) {
        this.classWriter = classWriter;
        this.sourceClassReader = null;
        this.entries = new SymbolTable$Entry[256];
        this.constantPoolCount = 1;
        this.constantPool = new ByteVector();
    }

    SymbolTable(ClassWriter classWriter, ClassReader classReader) {
        this.classWriter = classWriter;
        this.sourceClassReader = classReader;
        byte[] inputBytes = classReader.classFileBuffer;
        int constantPoolOffset = classReader.getItem(1) - 1;
        int constantPoolLength = classReader.header - constantPoolOffset;
        this.constantPoolCount = classReader.getItemCount();
        this.constantPool = new ByteVector(constantPoolLength);
        this.constantPool.putByteArray(inputBytes, constantPoolOffset, constantPoolLength);
        this.entries = new SymbolTable$Entry[this.constantPoolCount * 2];
        char[] charBuffer = new char[classReader.getMaxStringLength()];
        boolean hasBootstrapMethods = false;
        int i = 1;
        while (true) {
            int itemIndex = i;
            if (itemIndex < this.constantPoolCount) {
                int itemOffset = classReader.getItem(itemIndex);
                byte b2 = inputBytes[itemOffset - 1];
                switch (b2) {
                    case 1:
                        addConstantUtf8(itemIndex, classReader.readUtf(itemIndex, charBuffer));
                        break;
                    case 2:
                    case 13:
                    case 14:
                    default:
                        throw new IllegalArgumentException();
                    case 3:
                    case 4:
                        addConstantIntegerOrFloat(itemIndex, b2, classReader.readInt(itemOffset));
                        break;
                    case 5:
                    case 6:
                        addConstantLongOrDouble(itemIndex, b2, classReader.readLong(itemOffset));
                        break;
                    case 7:
                    case 8:
                    case 16:
                    case 19:
                    case 20:
                        addConstantUtf8Reference(itemIndex, b2, classReader.readUTF8(itemOffset, charBuffer));
                        break;
                    case 9:
                    case 10:
                    case 11:
                        int nameAndTypeItemOffset = classReader.getItem(classReader.readUnsignedShort(itemOffset + 2));
                        addConstantMemberReference(itemIndex, b2, classReader.readClass(itemOffset, charBuffer), classReader.readUTF8(nameAndTypeItemOffset, charBuffer), classReader.readUTF8(nameAndTypeItemOffset + 2, charBuffer));
                        break;
                    case 12:
                        addConstantNameAndType(itemIndex, classReader.readUTF8(itemOffset, charBuffer), classReader.readUTF8(itemOffset + 2, charBuffer));
                        break;
                    case 15:
                        int memberRefItemOffset = classReader.getItem(classReader.readUnsignedShort(itemOffset + 1));
                        int nameAndTypeItemOffset2 = classReader.getItem(classReader.readUnsignedShort(memberRefItemOffset + 2));
                        addConstantMethodHandle(itemIndex, classReader.readByte(itemOffset), classReader.readClass(memberRefItemOffset, charBuffer), classReader.readUTF8(nameAndTypeItemOffset2, charBuffer), classReader.readUTF8(nameAndTypeItemOffset2 + 2, charBuffer));
                        break;
                    case 17:
                    case 18:
                        hasBootstrapMethods = true;
                        int nameAndTypeItemOffset3 = classReader.getItem(classReader.readUnsignedShort(itemOffset + 2));
                        addConstantDynamicOrInvokeDynamicReference(b2, itemIndex, classReader.readUTF8(nameAndTypeItemOffset3, charBuffer), classReader.readUTF8(nameAndTypeItemOffset3 + 2, charBuffer), classReader.readUnsignedShort(itemOffset));
                        break;
                }
                i = itemIndex + ((b2 == 5 || b2 == 6) ? 2 : 1);
            } else {
                if (hasBootstrapMethods) {
                    copyBootstrapMethods(classReader, charBuffer);
                    return;
                }
                return;
            }
        }
    }

    private void copyBootstrapMethods(ClassReader classReader, char[] charBuffer) {
        int hashCode;
        byte[] inputBytes = classReader.classFileBuffer;
        int currentAttributeOffset = classReader.getFirstAttributeOffset();
        for (int i = classReader.readUnsignedShort(currentAttributeOffset - 2); i > 0; i--) {
            String attributeName = classReader.readUTF8(currentAttributeOffset, charBuffer);
            if ("BootstrapMethods".equals(attributeName)) {
                this.bootstrapMethodCount = classReader.readUnsignedShort(currentAttributeOffset + 6);
                break;
            }
            currentAttributeOffset += 6 + classReader.readInt(currentAttributeOffset + 2);
        }
        if (this.bootstrapMethodCount > 0) {
            int bootstrapMethodsOffset = currentAttributeOffset + 8;
            int bootstrapMethodsLength = classReader.readInt(currentAttributeOffset + 2) - 2;
            this.bootstrapMethods = new ByteVector(bootstrapMethodsLength);
            this.bootstrapMethods.putByteArray(inputBytes, bootstrapMethodsOffset, bootstrapMethodsLength);
            int currentOffset = bootstrapMethodsOffset;
            for (int i2 = 0; i2 < this.bootstrapMethodCount; i2++) {
                int offset = currentOffset - bootstrapMethodsOffset;
                int bootstrapMethodRef = classReader.readUnsignedShort(currentOffset);
                int currentOffset2 = currentOffset + 2;
                int numBootstrapArguments = classReader.readUnsignedShort(currentOffset2);
                currentOffset = currentOffset2 + 2;
                int iHashCode = classReader.readConst(bootstrapMethodRef, charBuffer).hashCode();
                while (true) {
                    hashCode = iHashCode;
                    int i3 = numBootstrapArguments;
                    numBootstrapArguments--;
                    if (i3 > 0) {
                        int bootstrapArgument = classReader.readUnsignedShort(currentOffset);
                        currentOffset += 2;
                        iHashCode = hashCode ^ classReader.readConst(bootstrapArgument, charBuffer).hashCode();
                    }
                }
                add(new SymbolTable$Entry(i2, 64, offset, hashCode & Integer.MAX_VALUE));
            }
        }
    }

    ClassReader getSource() {
        return this.sourceClassReader;
    }

    int getMajorVersion() {
        return this.majorVersion;
    }

    String getClassName() {
        return this.className;
    }

    int setMajorVersionAndClassName(int majorVersion, String className) {
        this.majorVersion = majorVersion;
        this.className = className;
        return addConstantClass(className).index;
    }

    int getConstantPoolCount() {
        return this.constantPoolCount;
    }

    int getConstantPoolLength() {
        return this.constantPool.length;
    }

    void putConstantPool(ByteVector output) {
        output.putShort(this.constantPoolCount).putByteArray(this.constantPool.data, 0, this.constantPool.length);
    }

    int computeBootstrapMethodsSize() {
        if (this.bootstrapMethods != null) {
            addConstantUtf8("BootstrapMethods");
            return 8 + this.bootstrapMethods.length;
        }
        return 0;
    }

    void putBootstrapMethods(ByteVector output) {
        if (this.bootstrapMethods != null) {
            output.putShort(addConstantUtf8("BootstrapMethods")).putInt(this.bootstrapMethods.length + 2).putShort(this.bootstrapMethodCount).putByteArray(this.bootstrapMethods.data, 0, this.bootstrapMethods.length);
        }
    }

    private SymbolTable$Entry get(int hashCode) {
        return this.entries[hashCode % this.entries.length];
    }

    private SymbolTable$Entry put(SymbolTable$Entry entry) {
        if (this.entryCount > (this.entries.length * 3) / 4) {
            int currentCapacity = this.entries.length;
            int newCapacity = (currentCapacity * 2) + 1;
            SymbolTable$Entry[] newEntries = new SymbolTable$Entry[newCapacity];
            for (int i = currentCapacity - 1; i >= 0; i--) {
                SymbolTable$Entry symbolTable$Entry = this.entries[i];
                while (true) {
                    SymbolTable$Entry currentEntry = symbolTable$Entry;
                    if (currentEntry != null) {
                        int newCurrentEntryIndex = currentEntry.hashCode % newCapacity;
                        SymbolTable$Entry nextEntry = currentEntry.next;
                        currentEntry.next = newEntries[newCurrentEntryIndex];
                        newEntries[newCurrentEntryIndex] = currentEntry;
                        symbolTable$Entry = nextEntry;
                    }
                }
            }
            this.entries = newEntries;
        }
        this.entryCount++;
        int index = entry.hashCode % this.entries.length;
        entry.next = this.entries[index];
        this.entries[index] = entry;
        return entry;
    }

    private void add(SymbolTable$Entry entry) {
        this.entryCount++;
        int index = entry.hashCode % this.entries.length;
        entry.next = this.entries[index];
        this.entries[index] = entry;
    }

    Symbol addConstant(Object value) {
        if (value instanceof Integer) {
            return addConstantInteger(((Integer) value).intValue());
        }
        if (value instanceof Byte) {
            return addConstantInteger(((Byte) value).intValue());
        }
        if (value instanceof Character) {
            return addConstantInteger(((Character) value).charValue());
        }
        if (value instanceof Short) {
            return addConstantInteger(((Short) value).intValue());
        }
        if (value instanceof Boolean) {
            return addConstantInteger(((Boolean) value).booleanValue() ? 1 : 0);
        }
        if (value instanceof Float) {
            return addConstantFloat(((Float) value).floatValue());
        }
        if (value instanceof Long) {
            return addConstantLong(((Long) value).longValue());
        }
        if (value instanceof Double) {
            return addConstantDouble(((Double) value).doubleValue());
        }
        if (value instanceof String) {
            return addConstantString((String) value);
        }
        if (value instanceof Type) {
            Type type = (Type) value;
            int typeSort = type.getSort();
            if (typeSort == 10) {
                return addConstantClass(type.getInternalName());
            }
            if (typeSort == 11) {
                return addConstantMethodType(type.getDescriptor());
            }
            return addConstantClass(type.getDescriptor());
        }
        if (value instanceof Handle) {
            Handle handle = (Handle) value;
            return addConstantMethodHandle(handle.getTag(), handle.getOwner(), handle.getName(), handle.getDesc(), handle.isInterface());
        }
        if (value instanceof ConstantDynamic) {
            ConstantDynamic constantDynamic = (ConstantDynamic) value;
            return addConstantDynamic(constantDynamic.getName(), constantDynamic.getDescriptor(), constantDynamic.getBootstrapMethod(), constantDynamic.getBootstrapMethodArgumentsUnsafe());
        }
        throw new IllegalArgumentException("value " + value);
    }

    Symbol addConstantClass(String value) {
        return addConstantUtf8Reference(7, value);
    }

    Symbol addConstantFieldref(String owner, String name, String descriptor) {
        return addConstantMemberReference(9, owner, name, descriptor);
    }

    Symbol addConstantMethodref(String owner, String name, String descriptor, boolean isInterface) {
        int tag = isInterface ? 11 : 10;
        return addConstantMemberReference(tag, owner, name, descriptor);
    }

    private SymbolTable$Entry addConstantMemberReference(int tag, String owner, String name, String descriptor) {
        int hashCode = hash(tag, owner, name, descriptor);
        SymbolTable$Entry symbolTable$Entry = get(hashCode);
        while (true) {
            SymbolTable$Entry entry = symbolTable$Entry;
            if (entry != null) {
                if (entry.tag == tag && entry.hashCode == hashCode && entry.owner.equals(owner) && entry.name.equals(name) && entry.value.equals(descriptor)) {
                    return entry;
                }
                symbolTable$Entry = entry.next;
            } else {
                this.constantPool.put122(tag, addConstantClass(owner).index, addConstantNameAndType(name, descriptor));
                int i = this.constantPoolCount;
                this.constantPoolCount = i + 1;
                return put(new SymbolTable$Entry(i, tag, owner, name, descriptor, 0L, hashCode));
            }
        }
    }

    private void addConstantMemberReference(int index, int tag, String owner, String name, String descriptor) {
        add(new SymbolTable$Entry(index, tag, owner, name, descriptor, 0L, hash(tag, owner, name, descriptor)));
    }

    Symbol addConstantString(String value) {
        return addConstantUtf8Reference(8, value);
    }

    Symbol addConstantInteger(int value) {
        return addConstantIntegerOrFloat(3, value);
    }

    Symbol addConstantFloat(float value) {
        return addConstantIntegerOrFloat(4, Float.floatToRawIntBits(value));
    }

    private Symbol addConstantIntegerOrFloat(int tag, int value) {
        int hashCode = hash(tag, value);
        SymbolTable$Entry symbolTable$Entry = get(hashCode);
        while (true) {
            SymbolTable$Entry entry = symbolTable$Entry;
            if (entry != null) {
                if (entry.tag == tag && entry.hashCode == hashCode && entry.data == value) {
                    return entry;
                }
                symbolTable$Entry = entry.next;
            } else {
                this.constantPool.putByte(tag).putInt(value);
                int i = this.constantPoolCount;
                this.constantPoolCount = i + 1;
                return put(new SymbolTable$Entry(i, tag, value, hashCode));
            }
        }
    }

    private void addConstantIntegerOrFloat(int index, int tag, int value) {
        add(new SymbolTable$Entry(index, tag, value, hash(tag, value)));
    }

    Symbol addConstantLong(long value) {
        return addConstantLongOrDouble(5, value);
    }

    Symbol addConstantDouble(double value) {
        return addConstantLongOrDouble(6, Double.doubleToRawLongBits(value));
    }

    private Symbol addConstantLongOrDouble(int tag, long value) {
        int hashCode = hash(tag, value);
        SymbolTable$Entry symbolTable$Entry = get(hashCode);
        while (true) {
            SymbolTable$Entry entry = symbolTable$Entry;
            if (entry != null) {
                if (entry.tag == tag && entry.hashCode == hashCode && entry.data == value) {
                    return entry;
                }
                symbolTable$Entry = entry.next;
            } else {
                int index = this.constantPoolCount;
                this.constantPool.putByte(tag).putLong(value);
                this.constantPoolCount += 2;
                return put(new SymbolTable$Entry(index, tag, value, hashCode));
            }
        }
    }

    private void addConstantLongOrDouble(int index, int tag, long value) {
        add(new SymbolTable$Entry(index, tag, value, hash(tag, value)));
    }

    int addConstantNameAndType(String name, String descriptor) {
        int hashCode = hash(12, name, descriptor);
        SymbolTable$Entry symbolTable$Entry = get(hashCode);
        while (true) {
            SymbolTable$Entry entry = symbolTable$Entry;
            if (entry != null) {
                if (entry.tag == 12 && entry.hashCode == hashCode && entry.name.equals(name) && entry.value.equals(descriptor)) {
                    return entry.index;
                }
                symbolTable$Entry = entry.next;
            } else {
                this.constantPool.put122(12, addConstantUtf8(name), addConstantUtf8(descriptor));
                int i = this.constantPoolCount;
                this.constantPoolCount = i + 1;
                return put(new SymbolTable$Entry(i, 12, name, descriptor, hashCode)).index;
            }
        }
    }

    private void addConstantNameAndType(int index, String name, String descriptor) {
        add(new SymbolTable$Entry(index, 12, name, descriptor, hash(12, name, descriptor)));
    }

    int addConstantUtf8(String value) {
        int hashCode = hash(1, value);
        SymbolTable$Entry symbolTable$Entry = get(hashCode);
        while (true) {
            SymbolTable$Entry entry = symbolTable$Entry;
            if (entry != null) {
                if (entry.tag == 1 && entry.hashCode == hashCode && entry.value.equals(value)) {
                    return entry.index;
                }
                symbolTable$Entry = entry.next;
            } else {
                this.constantPool.putByte(1).putUTF8(value);
                int i = this.constantPoolCount;
                this.constantPoolCount = i + 1;
                return put(new SymbolTable$Entry(i, 1, value, hashCode)).index;
            }
        }
    }

    private void addConstantUtf8(int index, String value) {
        add(new SymbolTable$Entry(index, 1, value, hash(1, value)));
    }

    Symbol addConstantMethodHandle(int referenceKind, String owner, String name, String descriptor, boolean isInterface) {
        int hashCode = hash(15, owner, name, descriptor, referenceKind);
        SymbolTable$Entry symbolTable$Entry = get(hashCode);
        while (true) {
            SymbolTable$Entry entry = symbolTable$Entry;
            if (entry != null) {
                if (entry.tag == 15 && entry.hashCode == hashCode && entry.data == referenceKind && entry.owner.equals(owner) && entry.name.equals(name) && entry.value.equals(descriptor)) {
                    return entry;
                }
                symbolTable$Entry = entry.next;
            } else {
                if (referenceKind <= 4) {
                    this.constantPool.put112(15, referenceKind, addConstantFieldref(owner, name, descriptor).index);
                } else {
                    this.constantPool.put112(15, referenceKind, addConstantMethodref(owner, name, descriptor, isInterface).index);
                }
                int i = this.constantPoolCount;
                this.constantPoolCount = i + 1;
                return put(new SymbolTable$Entry(i, 15, owner, name, descriptor, referenceKind, hashCode));
            }
        }
    }

    private void addConstantMethodHandle(int index, int referenceKind, String owner, String name, String descriptor) {
        int hashCode = hash(15, owner, name, descriptor, referenceKind);
        add(new SymbolTable$Entry(index, 15, owner, name, descriptor, referenceKind, hashCode));
    }

    Symbol addConstantMethodType(String methodDescriptor) {
        return addConstantUtf8Reference(16, methodDescriptor);
    }

    Symbol addConstantDynamic(String name, String descriptor, Handle bootstrapMethodHandle, Object... bootstrapMethodArguments) {
        Symbol bootstrapMethod = addBootstrapMethod(bootstrapMethodHandle, bootstrapMethodArguments);
        return addConstantDynamicOrInvokeDynamicReference(17, name, descriptor, bootstrapMethod.index);
    }

    Symbol addConstantInvokeDynamic(String name, String descriptor, Handle bootstrapMethodHandle, Object... bootstrapMethodArguments) {
        Symbol bootstrapMethod = addBootstrapMethod(bootstrapMethodHandle, bootstrapMethodArguments);
        return addConstantDynamicOrInvokeDynamicReference(18, name, descriptor, bootstrapMethod.index);
    }

    private Symbol addConstantDynamicOrInvokeDynamicReference(int tag, String name, String descriptor, int bootstrapMethodIndex) {
        int hashCode = hash(tag, name, descriptor, bootstrapMethodIndex);
        SymbolTable$Entry symbolTable$Entry = get(hashCode);
        while (true) {
            SymbolTable$Entry entry = symbolTable$Entry;
            if (entry != null) {
                if (entry.tag == tag && entry.hashCode == hashCode && entry.data == bootstrapMethodIndex && entry.name.equals(name) && entry.value.equals(descriptor)) {
                    return entry;
                }
                symbolTable$Entry = entry.next;
            } else {
                this.constantPool.put122(tag, bootstrapMethodIndex, addConstantNameAndType(name, descriptor));
                int i = this.constantPoolCount;
                this.constantPoolCount = i + 1;
                return put(new SymbolTable$Entry(i, tag, null, name, descriptor, bootstrapMethodIndex, hashCode));
            }
        }
    }

    private void addConstantDynamicOrInvokeDynamicReference(int tag, int index, String name, String descriptor, int bootstrapMethodIndex) {
        int hashCode = hash(tag, name, descriptor, bootstrapMethodIndex);
        add(new SymbolTable$Entry(index, tag, null, name, descriptor, bootstrapMethodIndex, hashCode));
    }

    Symbol addConstantModule(String moduleName) {
        return addConstantUtf8Reference(19, moduleName);
    }

    Symbol addConstantPackage(String packageName) {
        return addConstantUtf8Reference(20, packageName);
    }

    private Symbol addConstantUtf8Reference(int tag, String value) {
        int hashCode = hash(tag, value);
        SymbolTable$Entry symbolTable$Entry = get(hashCode);
        while (true) {
            SymbolTable$Entry entry = symbolTable$Entry;
            if (entry != null) {
                if (entry.tag == tag && entry.hashCode == hashCode && entry.value.equals(value)) {
                    return entry;
                }
                symbolTable$Entry = entry.next;
            } else {
                this.constantPool.put12(tag, addConstantUtf8(value));
                int i = this.constantPoolCount;
                this.constantPoolCount = i + 1;
                return put(new SymbolTable$Entry(i, tag, value, hashCode));
            }
        }
    }

    private void addConstantUtf8Reference(int index, int tag, String value) {
        add(new SymbolTable$Entry(index, tag, value, hash(tag, value)));
    }

    Symbol addBootstrapMethod(Handle bootstrapMethodHandle, Object... bootstrapMethodArguments) {
        ByteVector bootstrapMethodsAttribute = this.bootstrapMethods;
        if (bootstrapMethodsAttribute == null) {
            ByteVector byteVector = new ByteVector();
            this.bootstrapMethods = byteVector;
            bootstrapMethodsAttribute = byteVector;
        }
        int numBootstrapArguments = bootstrapMethodArguments.length;
        int[] bootstrapMethodArgumentIndexes = new int[numBootstrapArguments];
        for (int i = 0; i < numBootstrapArguments; i++) {
            bootstrapMethodArgumentIndexes[i] = addConstant(bootstrapMethodArguments[i]).index;
        }
        int bootstrapMethodOffset = bootstrapMethodsAttribute.length;
        bootstrapMethodsAttribute.putShort(addConstantMethodHandle(bootstrapMethodHandle.getTag(), bootstrapMethodHandle.getOwner(), bootstrapMethodHandle.getName(), bootstrapMethodHandle.getDesc(), bootstrapMethodHandle.isInterface()).index);
        bootstrapMethodsAttribute.putShort(numBootstrapArguments);
        for (int i2 = 0; i2 < numBootstrapArguments; i2++) {
            bootstrapMethodsAttribute.putShort(bootstrapMethodArgumentIndexes[i2]);
        }
        int bootstrapMethodlength = bootstrapMethodsAttribute.length - bootstrapMethodOffset;
        int hashCode = bootstrapMethodHandle.hashCode();
        for (Object bootstrapMethodArgument : bootstrapMethodArguments) {
            hashCode ^= bootstrapMethodArgument.hashCode();
        }
        return addBootstrapMethod(bootstrapMethodOffset, bootstrapMethodlength, hashCode & Integer.MAX_VALUE);
    }

    private Symbol addBootstrapMethod(int offset, int length, int hashCode) {
        byte[] bootstrapMethodsData = this.bootstrapMethods.data;
        SymbolTable$Entry symbolTable$Entry = get(hashCode);
        while (true) {
            SymbolTable$Entry entry = symbolTable$Entry;
            if (entry != null) {
                if (entry.tag == 64 && entry.hashCode == hashCode) {
                    int otherOffset = (int) entry.data;
                    boolean isSameBootstrapMethod = true;
                    for (int i = 0; i < length; i++) {
                        if (bootstrapMethodsData[offset + i] != bootstrapMethodsData[otherOffset + i]) {
                            isSameBootstrapMethod = false;
                            break;
                        }
                    }
                    if (isSameBootstrapMethod) {
                        this.bootstrapMethods.length = offset;
                        return entry;
                    }
                }
                symbolTable$Entry = entry.next;
            } else {
                int i2 = this.bootstrapMethodCount;
                this.bootstrapMethodCount = i2 + 1;
                return put(new SymbolTable$Entry(i2, 64, offset, hashCode));
            }
        }
    }

    Symbol getType(int typeIndex) {
        return this.typeTable[typeIndex];
    }

    int addType(String value) {
        int hashCode = hash(128, value);
        SymbolTable$Entry symbolTable$Entry = get(hashCode);
        while (true) {
            SymbolTable$Entry entry = symbolTable$Entry;
            if (entry != null) {
                if (entry.tag == 128 && entry.hashCode == hashCode && entry.value.equals(value)) {
                    return entry.index;
                }
                symbolTable$Entry = entry.next;
            } else {
                return addTypeInternal(new SymbolTable$Entry(this.typeCount, 128, value, hashCode));
            }
        }
    }

    int addUninitializedType(String value, int bytecodeOffset) {
        int hashCode = hash(Opcodes.LOR, value, bytecodeOffset);
        SymbolTable$Entry symbolTable$Entry = get(hashCode);
        while (true) {
            SymbolTable$Entry entry = symbolTable$Entry;
            if (entry != null) {
                if (entry.tag == 129 && entry.hashCode == hashCode && entry.data == bytecodeOffset && entry.value.equals(value)) {
                    return entry.index;
                }
                symbolTable$Entry = entry.next;
            } else {
                return addTypeInternal(new SymbolTable$Entry(this.typeCount, Opcodes.LOR, value, bytecodeOffset, hashCode));
            }
        }
    }

    int addMergedType(int typeTableIndex1, int typeTableIndex2) {
        long data = typeTableIndex1 < typeTableIndex2 ? ((long) typeTableIndex1) | (((long) typeTableIndex2) << 32) : ((long) typeTableIndex2) | (((long) typeTableIndex1) << 32);
        int hashCode = hash(130, typeTableIndex1 + typeTableIndex2);
        SymbolTable$Entry symbolTable$Entry = get(hashCode);
        while (true) {
            SymbolTable$Entry entry = symbolTable$Entry;
            if (entry != null) {
                if (entry.tag == 130 && entry.hashCode == hashCode && entry.data == data) {
                    return entry.info;
                }
                symbolTable$Entry = entry.next;
            } else {
                String type1 = this.typeTable[typeTableIndex1].value;
                String type2 = this.typeTable[typeTableIndex2].value;
                int commonSuperTypeIndex = addType(this.classWriter.getCommonSuperClass(type1, type2));
                put(new SymbolTable$Entry(this.typeCount, 130, data, hashCode)).info = commonSuperTypeIndex;
                return commonSuperTypeIndex;
            }
        }
    }

    private int addTypeInternal(SymbolTable$Entry entry) {
        if (this.typeTable == null) {
            this.typeTable = new SymbolTable$Entry[16];
        }
        if (this.typeCount == this.typeTable.length) {
            SymbolTable$Entry[] newTypeTable = new SymbolTable$Entry[2 * this.typeTable.length];
            System.arraycopy(this.typeTable, 0, newTypeTable, 0, this.typeTable.length);
            this.typeTable = newTypeTable;
        }
        SymbolTable$Entry[] symbolTable$EntryArr = this.typeTable;
        int i = this.typeCount;
        this.typeCount = i + 1;
        symbolTable$EntryArr[i] = entry;
        return put(entry).index;
    }

    private static int hash(int tag, int value) {
        return Integer.MAX_VALUE & (tag + value);
    }

    private static int hash(int tag, long value) {
        return Integer.MAX_VALUE & (tag + ((int) value) + ((int) (value >>> 32)));
    }

    private static int hash(int tag, String value) {
        return Integer.MAX_VALUE & (tag + value.hashCode());
    }

    private static int hash(int tag, String value1, int value2) {
        return Integer.MAX_VALUE & (tag + value1.hashCode() + value2);
    }

    private static int hash(int tag, String value1, String value2) {
        return Integer.MAX_VALUE & (tag + (value1.hashCode() * value2.hashCode()));
    }

    private static int hash(int tag, String value1, String value2, int value3) {
        return Integer.MAX_VALUE & (tag + (value1.hashCode() * value2.hashCode() * (value3 + 1)));
    }

    private static int hash(int tag, String value1, String value2, String value3) {
        return Integer.MAX_VALUE & (tag + (value1.hashCode() * value2.hashCode() * value3.hashCode()));
    }

    private static int hash(int tag, String value1, String value2, String value3, int value4) {
        return Integer.MAX_VALUE & (tag + (value1.hashCode() * value2.hashCode() * value3.hashCode() * value4));
    }
}
