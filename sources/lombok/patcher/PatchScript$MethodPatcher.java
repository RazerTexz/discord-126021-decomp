package lombok.patcher;

import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: app.apk:lombok/patcher/PatchScript$MethodPatcher.SCL.lombok */
protected class PatchScript$MethodPatcher extends ClassVisitor {
    private List<TargetMatcher> targets;
    private String ownClassSpec;
    private final PatchScript$MethodPatcherFactory factory;
    private List<Hook> transplants;
    private final TransplantMapper transplantMapper;
    private int classFileFormatVersion;

    public PatchScript$MethodPatcher(ClassVisitor cv, TransplantMapper transplantMapper, PatchScript$MethodPatcherFactory factory) {
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
