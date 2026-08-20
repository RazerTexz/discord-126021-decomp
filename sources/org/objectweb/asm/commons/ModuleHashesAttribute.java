package org.objectweb.asm.commons;

import java.util.ArrayList;
import java.util.List;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ByteVector;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/commons/ModuleHashesAttribute.SCL.lombok */
public final class ModuleHashesAttribute extends Attribute {
    public String algorithm;
    public List<String> modules;
    public List<byte[]> hashes;

    public ModuleHashesAttribute(String algorithm, List<String> modules, List<byte[]> hashes) {
        super("ModuleHashes");
        this.algorithm = algorithm;
        this.modules = modules;
        this.hashes = hashes;
    }

    public ModuleHashesAttribute() {
        this(null, null, null);
    }

    @Override // org.objectweb.asm.Attribute
    protected Attribute read(ClassReader classReader, int offset, int length, char[] charBuffer, int codeAttributeOffset, Label[] labels) {
        String hashAlgorithm = classReader.readUTF8(offset, charBuffer);
        int currentOffset = offset + 2;
        int numModules = classReader.readUnsignedShort(currentOffset);
        int currentOffset2 = currentOffset + 2;
        ArrayList<String> moduleList = new ArrayList<>(numModules);
        ArrayList<byte[]> hashList = new ArrayList<>(numModules);
        for (int i = 0; i < numModules; i++) {
            String module = classReader.readModule(currentOffset2, charBuffer);
            int currentOffset3 = currentOffset2 + 2;
            moduleList.add(module);
            int hashLength = classReader.readUnsignedShort(currentOffset3);
            currentOffset2 = currentOffset3 + 2;
            byte[] hash = new byte[hashLength];
            for (int j = 0; j < hashLength; j++) {
                hash[j] = (byte) (classReader.readByte(currentOffset2) & 255);
                currentOffset2++;
            }
            hashList.add(hash);
        }
        return new ModuleHashesAttribute(hashAlgorithm, moduleList, hashList);
    }

    @Override // org.objectweb.asm.Attribute
    protected ByteVector write(ClassWriter classWriter, byte[] code, int codeLength, int maxStack, int maxLocals) {
        ByteVector byteVector = new ByteVector();
        byteVector.putShort(classWriter.newUTF8(this.algorithm));
        if (this.modules == null) {
            byteVector.putShort(0);
        } else {
            int numModules = this.modules.size();
            byteVector.putShort(numModules);
            for (int i = 0; i < numModules; i++) {
                String module = this.modules.get(i);
                byte[] hash = this.hashes.get(i);
                byteVector.putShort(classWriter.newModule(module)).putShort(hash.length).putByteArray(hash, 0, hash.length);
            }
        }
        return byteVector;
    }
}
