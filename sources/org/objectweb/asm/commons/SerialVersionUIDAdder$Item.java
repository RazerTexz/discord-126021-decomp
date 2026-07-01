package org.objectweb.asm.commons;

/* JADX INFO: loaded from: app.apk:org/objectweb/asm/commons/SerialVersionUIDAdder$Item.SCL.lombok */
final class SerialVersionUIDAdder$Item implements Comparable<SerialVersionUIDAdder$Item> {
    final String name;
    final int access;
    final String descriptor;

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(SerialVersionUIDAdder$Item serialVersionUIDAdder$Item) {
        return compareTo2(serialVersionUIDAdder$Item);
    }

    SerialVersionUIDAdder$Item(String name, int access, String descriptor) {
        this.name = name;
        this.access = access;
        this.descriptor = descriptor;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(SerialVersionUIDAdder$Item item) {
        int result = this.name.compareTo(item.name);
        if (result == 0) {
            result = this.descriptor.compareTo(item.descriptor);
        }
        return result;
    }

    public boolean equals(Object other) {
        return (other instanceof SerialVersionUIDAdder$Item) && compareTo2((SerialVersionUIDAdder$Item) other) == 0;
    }

    public int hashCode() {
        return this.name.hashCode() ^ this.descriptor.hashCode();
    }
}
