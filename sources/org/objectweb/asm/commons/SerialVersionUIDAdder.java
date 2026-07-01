package org.objectweb.asm.commons;

import com.discord.widgets.chat.input.MentionUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: app.apk:org/objectweb/asm/commons/SerialVersionUIDAdder.SCL.lombok */
public class SerialVersionUIDAdder extends ClassVisitor {
    private static final String CLINIT = "<clinit>";
    private boolean computeSvuid;
    private boolean hasSvuid;
    private int access;
    private String name;
    private String[] interfaces;
    private Collection<Item> svuidFields;
    private boolean hasStaticInitializer;
    private Collection<Item> svuidConstructors;
    private Collection<Item> svuidMethods;

    public SerialVersionUIDAdder(ClassVisitor classVisitor) {
        this(Opcodes.ASM9, classVisitor);
        if (getClass() != SerialVersionUIDAdder.class) {
            throw new IllegalStateException();
        }
    }

    protected SerialVersionUIDAdder(int api, ClassVisitor classVisitor) {
        super(api, classVisitor);
    }

    @Override // org.objectweb.asm.ClassVisitor
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        this.computeSvuid = (access & 16384) == 0;
        if (this.computeSvuid) {
            this.name = name;
            this.access = access;
            this.interfaces = (String[]) interfaces.clone();
            this.svuidFields = new ArrayList();
            this.svuidConstructors = new ArrayList();
            this.svuidMethods = new ArrayList();
        }
        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override // org.objectweb.asm.ClassVisitor
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        if (this.computeSvuid) {
            if (CLINIT.equals(name)) {
                this.hasStaticInitializer = true;
            }
            int mods = access & 3391;
            if ((access & 2) == 0) {
                if ("<init>".equals(name)) {
                    this.svuidConstructors.add(new Item(name, mods, descriptor));
                } else if (!CLINIT.equals(name)) {
                    this.svuidMethods.add(new Item(name, mods, descriptor));
                }
            }
        }
        return super.visitMethod(access, name, descriptor, signature, exceptions);
    }

    @Override // org.objectweb.asm.ClassVisitor
    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        if (this.computeSvuid) {
            if ("serialVersionUID".equals(name)) {
                this.computeSvuid = false;
                this.hasSvuid = true;
            }
            if ((access & 2) == 0 || (access & Opcodes.L2I) == 0) {
                int mods = access & 223;
                this.svuidFields.add(new Item(name, mods, desc));
            }
        }
        return super.visitField(access, name, desc, signature, value);
    }

    @Override // org.objectweb.asm.ClassVisitor
    public void visitInnerClass(String innerClassName, String outerName, String innerName, int innerClassAccess) {
        if (this.name != null && this.name.equals(innerClassName)) {
            this.access = innerClassAccess;
        }
        super.visitInnerClass(innerClassName, outerName, innerName, innerClassAccess);
    }

    @Override // org.objectweb.asm.ClassVisitor
    public void visitEnd() {
        if (this.computeSvuid && !this.hasSvuid) {
            try {
                addSVUID(computeSVUID());
            } catch (IOException e) {
                throw new IllegalStateException("Error while computing SVUID for " + this.name, e);
            }
        }
        super.visitEnd();
    }

    public boolean hasSVUID() {
        return this.hasSvuid;
    }

    protected void addSVUID(long svuid) {
        FieldVisitor fieldVisitor = super.visitField(24, "serialVersionUID", "J", null, Long.valueOf(svuid));
        if (fieldVisitor != null) {
            fieldVisitor.visitEnd();
        }
    }

    protected long computeSVUID() throws IOException {
        long svuid = 0;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            Throwable th = null;
            try {
                try {
                    dataOutputStream.writeUTF(this.name.replace(MentionUtils.SLASH_CHAR, '.'));
                    int mods = this.access;
                    if ((mods & 512) != 0) {
                        mods = this.svuidMethods.isEmpty() ? mods & (-1025) : mods | 1024;
                    }
                    dataOutputStream.writeInt(mods & 1553);
                    Arrays.sort(this.interfaces);
                    for (String interfaceName : this.interfaces) {
                        dataOutputStream.writeUTF(interfaceName.replace(MentionUtils.SLASH_CHAR, '.'));
                    }
                    writeItems(this.svuidFields, dataOutputStream, false);
                    if (this.hasStaticInitializer) {
                        dataOutputStream.writeUTF(CLINIT);
                        dataOutputStream.writeInt(8);
                        dataOutputStream.writeUTF("()V");
                    }
                    writeItems(this.svuidConstructors, dataOutputStream, true);
                    writeItems(this.svuidMethods, dataOutputStream, true);
                    dataOutputStream.flush();
                    byte[] hashBytes = computeSHAdigest(byteArrayOutputStream.toByteArray());
                    for (int i = Math.min(hashBytes.length, 8) - 1; i >= 0; i--) {
                        svuid = (svuid << 8) | ((long) (hashBytes[i] & 255));
                    }
                    if (dataOutputStream != null) {
                        if (0 != 0) {
                            try {
                                dataOutputStream.close();
                            } catch (Throwable th2) {
                            }
                        } else {
                            dataOutputStream.close();
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        if (0 != 0) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable th3) {
                            }
                        } else {
                            byteArrayOutputStream.close();
                        }
                    }
                    return svuid;
                } catch (Throwable th4) {
                    th = th4;
                    throw th4;
                }
            } catch (Throwable th5) {
                if (dataOutputStream != null) {
                    if (th != null) {
                        try {
                            dataOutputStream.close();
                        } catch (Throwable th6) {
                        }
                    } else {
                        dataOutputStream.close();
                    }
                }
                throw th5;
            }
        } catch (Throwable th7) {
            if (byteArrayOutputStream != null) {
                if (0 != 0) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th8) {
                    }
                } else {
                    byteArrayOutputStream.close();
                }
            }
            throw th7;
        }
    }

    protected byte[] computeSHAdigest(byte[] value) {
        try {
            return MessageDigest.getInstance("SHA").digest(value);
        } catch (NoSuchAlgorithmException e) {
            throw new UnsupportedOperationException(e);
        }
    }

    private static void writeItems(Collection<Item> itemCollection, DataOutput dataOutputStream, boolean dotted) throws IOException {
        Item[] items = (Item[]) itemCollection.toArray(new Item[0]);
        Arrays.sort(items);
        for (Item item : items) {
            dataOutputStream.writeUTF(item.name);
            dataOutputStream.writeInt(item.access);
            dataOutputStream.writeUTF(dotted ? item.descriptor.replace(MentionUtils.SLASH_CHAR, '.') : item.descriptor);
        }
    }

    /* JADX INFO: loaded from: app.apk:org/objectweb/asm/commons/SerialVersionUIDAdder$Item.SCL.lombok */
    private static final class Item implements Comparable<Item> {
        final String name;
        final int access;
        final String descriptor;

        Item(String name, int access, String descriptor) {
            this.name = name;
            this.access = access;
            this.descriptor = descriptor;
        }

        @Override // java.lang.Comparable
        public int compareTo(Item item) {
            int result = this.name.compareTo(item.name);
            if (result == 0) {
                result = this.descriptor.compareTo(item.descriptor);
            }
            return result;
        }

        public boolean equals(Object other) {
            return (other instanceof Item) && compareTo((Item) other) == 0;
        }

        public int hashCode() {
            return this.name.hashCode() ^ this.descriptor.hashCode();
        }
    }
}
