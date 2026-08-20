package org.objectweb.asm;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/CurrentFrame.SCL.lombok */
final class CurrentFrame extends Frame {
    CurrentFrame(Label owner) {
        super(owner);
    }

    @Override // org.objectweb.asm.Frame
    void execute(int opcode, int arg, Symbol symbolArg, SymbolTable symbolTable) {
        super.execute(opcode, arg, symbolArg, symbolTable);
        Frame successor = new Frame(null);
        merge(symbolTable, successor, 0);
        copyFrom(successor);
    }
}
