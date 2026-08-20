package org.objectweb.asm.tree.analysis;

import java.util.ArrayList;
import java.util.List;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/tree/analysis/Subroutine.SCL.lombok */
final class Subroutine {
    final LabelNode start;
    final boolean[] localsUsed;
    final List<JumpInsnNode> callers;

    Subroutine(LabelNode start, int maxLocals, JumpInsnNode caller) {
        this.start = start;
        this.localsUsed = new boolean[maxLocals];
        this.callers = new ArrayList();
        this.callers.add(caller);
    }

    Subroutine(Subroutine subroutine) {
        this.start = subroutine.start;
        this.localsUsed = (boolean[]) subroutine.localsUsed.clone();
        this.callers = new ArrayList(subroutine.callers);
    }

    public boolean merge(Subroutine subroutine) {
        boolean changed = false;
        for (int i = 0; i < this.localsUsed.length; i++) {
            if (subroutine.localsUsed[i] && !this.localsUsed[i]) {
                this.localsUsed[i] = true;
                changed = true;
            }
        }
        if (subroutine.start == this.start) {
            for (int i2 = 0; i2 < subroutine.callers.size(); i2++) {
                JumpInsnNode caller = subroutine.callers.get(i2);
                if (!this.callers.contains(caller)) {
                    this.callers.add(caller);
                    changed = true;
                }
            }
        }
        return changed;
    }
}
