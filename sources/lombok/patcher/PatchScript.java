package lombok.patcher;

import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: app.apk:lombok/patcher/PatchScript.SCL.lombok */
public abstract class PatchScript {

    /* JADX INFO: loaded from: app.apk:lombok/patcher/PatchScript$MethodPatcherFactory.SCL.lombok */
    public interface MethodPatcherFactory {
        MethodVisitor createMethodVisitor(String str, String str2, MethodVisitor methodVisitor, MethodLogistics methodLogistics);
    }

    public abstract Collection<String> getClassesToReload();

    public abstract boolean wouldPatch(String str);

    public abstract byte[] patch(String str, byte[] bArr, TransplantMapper transplantMapper);

    public String getPatchScriptName() {
        return getClass().getSimpleName();
    }

    public static boolean classMatches(String className, Collection<String> classSpecs) {
        for (String classSpec : classSpecs) {
            if (MethodTarget.typeMatches(className, classSpec)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: loaded from: app.apk:lombok/patcher/PatchScript$FixedClassWriter.SCL.lombok */
    private static class FixedClassWriter extends ClassWriter {
        FixedClassWriter(ClassReader classReader, int flags) {
            super(classReader, flags);
        }

        @Override // org.objectweb.asm.ClassWriter
        protected String getCommonSuperClass(String type1, String type2) {
            try {
                return super.getCommonSuperClass(type1, type2);
            } catch (Throwable unused) {
                return "java/lang/Object";
            }
        }
    }

    protected byte[] runASM(byte[] byteCode, boolean computeStacks, TransplantMapper transplantMapper) {
        ClassReader reader = new ClassReader(byteCode);
        int classFileFormatVersion = 48;
        if (byteCode.length > 7) {
            classFileFormatVersion = byteCode[7] & 255;
        }
        int flags = classFileFormatVersion < 50 ? 2 : 0;
        if (computeStacks) {
            flags |= 1;
        }
        ClassWriter writer = new FixedClassWriter(reader, flags);
        ClassVisitor visitor = createClassVisitor(writer, reader.getClassName(), transplantMapper);
        reader.accept(visitor, 0);
        return writer.toByteArray();
    }

    protected ClassVisitor createClassVisitor(ClassWriter writer, String classSpec, TransplantMapper transplantMapper) {
        throw new IllegalStateException("If you're going to call runASM, then you need to implement createClassVisitor");
    }

    private static byte[] readStream(String resourceName) {
        InputStream wrapStream = null;
        try {
            try {
                wrapStream = PatchScript.class.getResourceAsStream(resourceName);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] b2 = new byte[65536];
                while (true) {
                    int r = wrapStream.read(b2);
                    if (r == -1) {
                        break;
                    }
                    baos.write(b2, 0, r);
                }
                byte[] byteArray = baos.toByteArray();
                if (wrapStream != null) {
                    try {
                        wrapStream.close();
                    } catch (IOException unused) {
                    }
                }
                return byteArray;
            } catch (Throwable th) {
                if (wrapStream != null) {
                    try {
                        wrapStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("resource " + resourceName + " does not exist.", e);
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/patcher/PatchScript$NoopClassVisitor.SCL.lombok */
    private static abstract class NoopClassVisitor extends ClassVisitor {
        public NoopClassVisitor() {
            super(Opcodes.ASM7);
        }

        @Override // org.objectweb.asm.ClassVisitor
        public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        }

        @Override // org.objectweb.asm.ClassVisitor
        public void visitAttribute(Attribute attr) {
        }

        @Override // org.objectweb.asm.ClassVisitor
        public void visitEnd() {
        }

        @Override // org.objectweb.asm.ClassVisitor
        public void visitOuterClass(String owner, String name, String desc) {
        }

        @Override // org.objectweb.asm.ClassVisitor
        public void visitSource(String source, String debug) {
        }

        @Override // org.objectweb.asm.ClassVisitor
        public void visitInnerClass(String name, String outerName, String innerName, int access) {
        }

        @Override // org.objectweb.asm.ClassVisitor
        public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
            return null;
        }

        @Override // org.objectweb.asm.ClassVisitor
        public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
            return null;
        }

        @Override // org.objectweb.asm.ClassVisitor
        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
            return null;
        }
    }

    protected static void insertMethod(final Hook methodToInsert, final MethodVisitor target) {
        byte[] classData = readStream(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN + methodToInsert.getClassSpec() + ".class");
        ClassReader reader = new ClassReader(classData);
        ClassVisitor methodFinder = new NoopClassVisitor() { // from class: lombok.patcher.PatchScript.1
            @Override // lombok.patcher.PatchScript.NoopClassVisitor, org.objectweb.asm.ClassVisitor
            public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
                if (name.equals(methodToInsert.getMethodName()) && desc.equals(methodToInsert.getMethodDescriptor())) {
                    return new InsertBodyOfMethodIntoAnotherVisitor(target, null);
                }
                return null;
            }
        };
        reader.accept(methodFinder, 0);
    }

    protected static void transplantMethod(String resourceName, final Hook methodToTransplant, final ClassVisitor target) {
        byte[] classData = readStream(resourceName);
        ClassReader reader = new ClassReader(classData);
        ClassVisitor methodFinder = new NoopClassVisitor() { // from class: lombok.patcher.PatchScript.2
            @Override // lombok.patcher.PatchScript.NoopClassVisitor, org.objectweb.asm.ClassVisitor
            public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
                if (name.equals(methodToTransplant.getMethodName()) && desc.equals(methodToTransplant.getMethodDescriptor())) {
                    return target.visitMethod(access, name, desc, signature, exceptions);
                }
                return null;
            }
        };
        reader.accept(methodFinder, 0);
    }

    /* JADX INFO: loaded from: app.apk:lombok/patcher/PatchScript$InsertBodyOfMethodIntoAnotherVisitor.SCL.lombok */
    private static final class InsertBodyOfMethodIntoAnotherVisitor extends MethodVisitor {
        /* synthetic */ InsertBodyOfMethodIntoAnotherVisitor(MethodVisitor methodVisitor, InsertBodyOfMethodIntoAnotherVisitor insertBodyOfMethodIntoAnotherVisitor) {
            this(methodVisitor);
        }

        private InsertBodyOfMethodIntoAnotherVisitor(MethodVisitor mv) {
            super(Opcodes.ASM7, mv);
        }

        @Override // org.objectweb.asm.MethodVisitor
        public AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible) {
            return null;
        }

        @Override // org.objectweb.asm.MethodVisitor
        public void visitMaxs(int maxStack, int maxLocals) {
        }

        @Override // org.objectweb.asm.MethodVisitor
        public void visitLineNumber(int line, Label start) {
        }

        @Override // org.objectweb.asm.MethodVisitor
        public void visitFrame(int type, int nLocal, Object[] local, int nStack, Object[] stack) {
        }

        @Override // org.objectweb.asm.MethodVisitor
        public void visitEnd() {
        }

        @Override // org.objectweb.asm.MethodVisitor
        public void visitCode() {
        }

        @Override // org.objectweb.asm.MethodVisitor
        public void visitInsn(int opcode) {
            if (opcode == 177 || opcode == 176 || opcode == 172 || opcode == 175 || opcode == 174 || opcode == 173) {
                return;
            }
            super.visitInsn(opcode);
        }

        @Override // org.objectweb.asm.MethodVisitor
        public void visitAttribute(Attribute attr) {
        }

        @Override // org.objectweb.asm.MethodVisitor
        public AnnotationVisitor visitAnnotationDefault() {
            return null;
        }

        @Override // org.objectweb.asm.MethodVisitor
        public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
            return null;
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/patcher/PatchScript$MethodPatcher.SCL.lombok */
    protected static class MethodPatcher extends ClassVisitor {
        private List<TargetMatcher> targets;
        private String ownClassSpec;
        private final MethodPatcherFactory factory;
        private List<Hook> transplants;
        private final TransplantMapper transplantMapper;
        private int classFileFormatVersion;

        public MethodPatcher(ClassVisitor cv, TransplantMapper transplantMapper, MethodPatcherFactory factory) {
            super(Opcodes.ASM7, cv);
            this.targets = new ArrayList();
            this.transplants = new ArrayList();
            this.factory = factory;
            this.transplantMapper = transplantMapper;
        }

        public String getOwnClassSpec() {
            return this.ownClassSpec;
        }

        public void addTargetMatcher(TargetMatcher t) {
            this.targets.add(t);
        }

        @Override // org.objectweb.asm.ClassVisitor
        public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
            this.ownClassSpec = name;
            this.classFileFormatVersion = version;
            super.visit(version, access, name, signature, superName, interfaces);
        }

        public void addTransplant(Hook transplant) {
            if (transplant == null) {
                throw new NullPointerException("transplant");
            }
            this.transplants.add(transplant);
        }

        @Override // org.objectweb.asm.ClassVisitor
        public void visitEnd() {
            for (Hook transplant : this.transplants) {
                String resourceName = AutocompleteViewModel.COMMAND_DISCOVER_TOKEN + this.transplantMapper.mapResourceName(this.classFileFormatVersion, String.valueOf(transplant.getClassSpec()) + ".class");
                PatchScript.transplantMethod(resourceName, transplant, this.cv);
            }
        }

        @Override // org.objectweb.asm.ClassVisitor
        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
            MethodVisitor visitor = super.visitMethod(access, name, desc, signature, exceptions);
            Iterator<Hook> it = this.transplants.iterator();
            while (it.hasNext()) {
                Hook h = it.next();
                if (h.getMethodName().equals(name) && h.getMethodDescriptor().equals(desc)) {
                    it.remove();
                }
            }
            for (TargetMatcher t : this.targets) {
                if (t.matches(this.ownClassSpec, name, desc)) {
                    return this.factory.createMethodVisitor(name, desc, visitor, new MethodLogistics(access, desc));
                }
            }
            return visitor;
        }
    }
}
