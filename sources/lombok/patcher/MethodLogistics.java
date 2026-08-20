package lombok.patcher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: discord-126021.apk:lombok/patcher/MethodLogistics.SCL.lombok */
public class MethodLogistics {
    private final int staticOffset;
    private final int returnOpcode;
    private final int returnSize;
    private final List<Integer> loadOpcodes;
    private final List<Integer> paramSizes;
    private final List<Integer> paramIndices;

    public MethodLogistics(int accessFlags, String descriptor) {
        this.staticOffset = (accessFlags & 8) != 0 ? 0 : 1;
        List<String> specs = MethodTarget.decomposeFullDesc(descriptor);
        Iterator<String> it = specs.iterator();
        String returnSpec = it.next();
        this.returnSize = sizeOf(returnSpec);
        this.returnOpcode = returnOpcodeFor(returnSpec);
        int index = this.staticOffset;
        List<Integer> paramSizes = new ArrayList<>();
        List<Integer> paramIndices = new ArrayList<>();
        List<Integer> loadOpcodes = new ArrayList<>();
        while (it.hasNext()) {
            String spec = it.next();
            int size = sizeOf(spec);
            paramSizes.add(Integer.valueOf(size));
            paramIndices.add(Integer.valueOf(index));
            loadOpcodes.add(Integer.valueOf(loadOpcodeFor(spec)));
            index += size;
        }
        this.paramSizes = Collections.unmodifiableList(paramSizes);
        this.paramIndices = Collections.unmodifiableList(paramIndices);
        this.loadOpcodes = Collections.unmodifiableList(loadOpcodes);
    }

    public boolean isStatic() {
        return this.staticOffset == 0;
    }

    public int getParamCount() {
        return this.paramSizes.size();
    }

    public int getReturnOpcode() {
        return this.returnOpcode;
    }

    public void generateLoadOpcodeForParam(int index, MethodVisitor mv) {
        mv.visitVarInsn(this.loadOpcodes.get(index).intValue(), this.paramIndices.get(index).intValue());
    }

    public void generateLoadOpcodeForThis(MethodVisitor mv) {
        if (!isStatic()) {
            mv.visitVarInsn(25, 0);
        } else {
            mv.visitInsn(1);
        }
    }

    public void generateReturnOpcode(MethodVisitor mv) {
        mv.visitInsn(this.returnOpcode);
    }

    public void generatePopForReturn(MethodVisitor mv) {
        mv.visitInsn(this.returnSize == 2 ? 88 : 87);
    }

    public void generateDupForReturn(MethodVisitor mv) {
        mv.visitInsn(this.returnSize == 2 ? 92 : 89);
    }

    public static void generateDupForType(String type, MethodVisitor mv) {
        switch (sizeOf(type)) {
            case 0:
                break;
            case 1:
            default:
                mv.visitInsn(89);
                break;
            case 2:
                mv.visitInsn(92);
                break;
        }
    }

    private static int loadOpcodeFor(String spec) {
        switch (spec.charAt(0)) {
            case 'B':
            case 'I':
            case 'S':
            case 'Z':
                return 21;
            case 'D':
                return 24;
            case 'F':
                return 23;
            case 'J':
                return 22;
            case 'L':
            case '[':
                return 25;
            case 'V':
                throw new IllegalArgumentException("There's no load opcode for 'void'");
            default:
                throw new IllegalStateException("Uhoh - bug - unrecognized JVM type: " + spec);
        }
    }

    private static int returnOpcodeFor(String returnSpec) {
        switch (returnSpec.charAt(0)) {
            case 'B':
            case 'I':
            case 'S':
            case 'Z':
                return Opcodes.IRETURN;
            case 'D':
                return 175;
            case 'F':
                return Opcodes.FRETURN;
            case 'J':
                return Opcodes.LRETURN;
            case 'L':
            case '[':
                return Opcodes.ARETURN;
            case 'V':
                return Opcodes.RETURN;
            default:
                throw new IllegalStateException("Uhoh - bug - unrecognized JVM type: " + returnSpec);
        }
    }

    private static int sizeOf(String spec) {
        switch (spec.charAt(0)) {
            case 'D':
            case 'J':
                return 2;
            case 'V':
                return 0;
            default:
                return 1;
        }
    }
}
