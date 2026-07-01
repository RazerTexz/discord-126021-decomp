package org.objectweb.asm;

/* JADX INFO: loaded from: app.apk:org/objectweb/asm/SymbolTable$Entry.SCL.lombok */
class SymbolTable$Entry extends Symbol {
    final int hashCode;
    SymbolTable$Entry next;

    SymbolTable$Entry(int index, int tag, String owner, String name, String value, long data, int hashCode) {
        super(index, tag, owner, name, value, data);
        this.hashCode = hashCode;
    }

    SymbolTable$Entry(int index, int tag, String value, int hashCode) {
        super(index, tag, null, null, value, 0L);
        this.hashCode = hashCode;
    }

    SymbolTable$Entry(int index, int tag, String value, long data, int hashCode) {
        super(index, tag, null, null, value, data);
        this.hashCode = hashCode;
    }

    SymbolTable$Entry(int index, int tag, String name, String value, int hashCode) {
        super(index, tag, null, name, value, 0L);
        this.hashCode = hashCode;
    }

    SymbolTable$Entry(int index, int tag, long data, int hashCode) {
        super(index, tag, null, null, null, data);
        this.hashCode = hashCode;
    }
}
