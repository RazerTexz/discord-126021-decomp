package lombok.patcher.scripts;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import lombok.patcher.PatchScript;
import lombok.patcher.TargetMatcher;
import lombok.patcher.TransplantMapper;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

/* JADX INFO: loaded from: discord-126021.apk:lombok/patcher/scripts/MethodLevelPatchScript.SCL.lombok */
public abstract class MethodLevelPatchScript extends PatchScript {
    private final Set<String> affectedClasses;
    private final Collection<TargetMatcher> matchers;

    protected abstract PatchScript.MethodPatcher createPatcher(ClassWriter classWriter, String str, TransplantMapper transplantMapper);

    public String describeMatchers() {
        if (this.matchers.size() == 0) {
            return "(No matchers)";
        }
        if (this.matchers.size() == 1) {
            return this.matchers.iterator().next().describe();
        }
        StringBuilder out = new StringBuilder("(");
        for (TargetMatcher tm : this.matchers) {
            out.append(tm.describe()).append(", ");
        }
        out.setLength(out.length() - 2);
        return out.append(")").toString();
    }

    public MethodLevelPatchScript(Collection<TargetMatcher> matchers) {
        this.matchers = matchers;
        Set<String> affected = new HashSet<>();
        for (TargetMatcher t : matchers) {
            affected.addAll(t.getAffectedClasses());
        }
        this.affectedClasses = Collections.unmodifiableSet(affected);
    }

    @Override // lombok.patcher.PatchScript
    public Collection<String> getClassesToReload() {
        return this.affectedClasses;
    }

    @Override // lombok.patcher.PatchScript
    public boolean wouldPatch(String className) {
        return classMatches(className, this.affectedClasses);
    }

    @Override // lombok.patcher.PatchScript
    public byte[] patch(String className, byte[] byteCode, TransplantMapper transplantMapper) {
        if (classMatches(className, this.affectedClasses)) {
            return runASM(byteCode, true, transplantMapper);
        }
        return null;
    }

    @Override // lombok.patcher.PatchScript
    protected final ClassVisitor createClassVisitor(ClassWriter writer, String classSpec, TransplantMapper transplantMapper) {
        PatchScript.MethodPatcher patcher = createPatcher(writer, classSpec, transplantMapper);
        for (TargetMatcher matcher : this.matchers) {
            patcher.addTargetMatcher(matcher);
        }
        return patcher;
    }
}
