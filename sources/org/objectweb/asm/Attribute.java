package org.objectweb.asm;

/* JADX INFO: loaded from: app.apk:org/objectweb/asm/Attribute.SCL.lombok */
public class Attribute {
    public final String type;
    private byte[] content;
    Attribute nextAttribute;

    protected Attribute(String type) {
        this.type = type;
    }

    public boolean isUnknown() {
        return true;
    }

    public boolean isCodeAttribute() {
        return false;
    }

    protected Label[] getLabels() {
        return new Label[0];
    }

    protected Attribute read(ClassReader classReader, int offset, int length, char[] charBuffer, int codeAttributeOffset, Label[] labels) {
        Attribute attribute = new Attribute(this.type);
        attribute.content = new byte[length];
        System.arraycopy(classReader.classFileBuffer, offset, attribute.content, 0, length);
        return attribute;
    }

    protected ByteVector write(ClassWriter classWriter, byte[] code, int codeLength, int maxStack, int maxLocals) {
        return new ByteVector(this.content);
    }

    final int getAttributeCount() {
        int count = 0;
        Attribute attribute = this;
        while (true) {
            Attribute attribute2 = attribute;
            if (attribute2 != null) {
                count++;
                attribute = attribute2.nextAttribute;
            } else {
                return count;
            }
        }
    }

    final int computeAttributesSize(SymbolTable symbolTable) {
        return computeAttributesSize(symbolTable, null, 0, -1, -1);
    }

    final int computeAttributesSize(SymbolTable symbolTable, byte[] code, int codeLength, int maxStack, int maxLocals) {
        ClassWriter classWriter = symbolTable.classWriter;
        int size = 0;
        Attribute attribute = this;
        while (true) {
            Attribute attribute2 = attribute;
            if (attribute2 != null) {
                symbolTable.addConstantUtf8(attribute2.type);
                size += 6 + attribute2.write(classWriter, code, codeLength, maxStack, maxLocals).length;
                attribute = attribute2.nextAttribute;
            } else {
                return size;
            }
        }
    }

    static int computeAttributesSize(SymbolTable symbolTable, int accessFlags, int signatureIndex) {
        int size = 0;
        if ((accessFlags & 4096) != 0 && symbolTable.getMajorVersion() < 49) {
            symbolTable.addConstantUtf8("Synthetic");
            size = 0 + 6;
        }
        if (signatureIndex != 0) {
            symbolTable.addConstantUtf8("Signature");
            size += 8;
        }
        if ((accessFlags & 131072) != 0) {
            symbolTable.addConstantUtf8("Deprecated");
            size += 6;
        }
        return size;
    }

    final void putAttributes(SymbolTable symbolTable, ByteVector output) {
        putAttributes(symbolTable, null, 0, -1, -1, output);
    }

    final void putAttributes(SymbolTable symbolTable, byte[] code, int codeLength, int maxStack, int maxLocals, ByteVector output) {
        ClassWriter classWriter = symbolTable.classWriter;
        Attribute attribute = this;
        while (true) {
            Attribute attribute2 = attribute;
            if (attribute2 != null) {
                ByteVector attributeContent = attribute2.write(classWriter, code, codeLength, maxStack, maxLocals);
                output.putShort(symbolTable.addConstantUtf8(attribute2.type)).putInt(attributeContent.length);
                output.putByteArray(attributeContent.data, 0, attributeContent.length);
                attribute = attribute2.nextAttribute;
            } else {
                return;
            }
        }
    }

    static void putAttributes(SymbolTable symbolTable, int accessFlags, int signatureIndex, ByteVector output) {
        if ((accessFlags & 4096) != 0 && symbolTable.getMajorVersion() < 49) {
            output.putShort(symbolTable.addConstantUtf8("Synthetic")).putInt(0);
        }
        if (signatureIndex != 0) {
            output.putShort(symbolTable.addConstantUtf8("Signature")).putInt(2).putShort(signatureIndex);
        }
        if ((accessFlags & 131072) != 0) {
            output.putShort(symbolTable.addConstantUtf8("Deprecated")).putInt(0);
        }
    }
}
