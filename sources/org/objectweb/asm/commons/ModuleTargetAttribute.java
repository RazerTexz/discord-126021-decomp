package org.objectweb.asm.commons;

import org.objectweb.asm.Attribute;
import org.objectweb.asm.ByteVector;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/commons/ModuleTargetAttribute.SCL.lombok */
public final class ModuleTargetAttribute extends Attribute {
    public String platform;

    public ModuleTargetAttribute(String platform) {
        super("ModuleTarget");
        this.platform = platform;
    }

    public ModuleTargetAttribute() {
        this(null);
    }

    @Override // org.objectweb.asm.Attribute
    protected Attribute read(ClassReader classReader, int offset, int length, char[] charBuffer, int codeOffset, Label[] labels) {
        return new ModuleTargetAttribute(classReader.readUTF8(offset, charBuffer));
    }

    @Override // org.objectweb.asm.Attribute
    protected ByteVector write(ClassWriter classWriter, byte[] code, int codeLength, int maxStack, int maxLocals) {
        ByteVector byteVector = new ByteVector();
        byteVector.putShort(this.platform == null ? 0 : classWriter.newUTF8(this.platform));
        return byteVector;
    }
}
