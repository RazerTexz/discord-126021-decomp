package org.objectweb.asm.tree;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: app.apk:org/objectweb/asm/tree/InsnList$InsnListIterator.SCL.lombok */
final class InsnList$InsnListIterator implements ListIterator {
    AbstractInsnNode nextInsn;
    AbstractInsnNode previousInsn;
    AbstractInsnNode remove;
    final /* synthetic */ InsnList this$0;

    InsnList$InsnListIterator(InsnList insnList, int index) {
        this.this$0 = insnList;
        if (index < 0 || index > insnList.size()) {
            throw new IndexOutOfBoundsException();
        }
        if (index == insnList.size()) {
            this.nextInsn = null;
            this.previousInsn = insnList.getLast();
            return;
        }
        AbstractInsnNode currentInsn = insnList.getFirst();
        for (int i = 0; i < index; i++) {
            currentInsn = currentInsn.nextInsn;
        }
        this.nextInsn = currentInsn;
        this.previousInsn = currentInsn.previousInsn;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.nextInsn != null;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        if (this.nextInsn == null) {
            throw new NoSuchElementException();
        }
        AbstractInsnNode result = this.nextInsn;
        this.previousInsn = result;
        this.nextInsn = result.nextInsn;
        this.remove = result;
        return result;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        if (this.remove != null) {
            if (this.remove == this.nextInsn) {
                this.nextInsn = this.nextInsn.nextInsn;
            } else {
                this.previousInsn = this.previousInsn.previousInsn;
            }
            this.this$0.remove(this.remove);
            this.remove = null;
            return;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.previousInsn != null;
    }

    @Override // java.util.ListIterator
    public Object previous() {
        if (this.previousInsn == null) {
            throw new NoSuchElementException();
        }
        AbstractInsnNode result = this.previousInsn;
        this.nextInsn = result;
        this.previousInsn = result.previousInsn;
        this.remove = result;
        return result;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        if (this.nextInsn == null) {
            return this.this$0.size();
        }
        if (this.this$0.cache == null) {
            this.this$0.cache = this.this$0.toArray();
        }
        return this.nextInsn.index;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        if (this.previousInsn == null) {
            return -1;
        }
        if (this.this$0.cache == null) {
            this.this$0.cache = this.this$0.toArray();
        }
        return this.previousInsn.index;
    }

    @Override // java.util.ListIterator
    public void add(Object o) {
        if (this.nextInsn != null) {
            this.this$0.insertBefore(this.nextInsn, (AbstractInsnNode) o);
        } else if (this.previousInsn != null) {
            this.this$0.insert(this.previousInsn, (AbstractInsnNode) o);
        } else {
            this.this$0.add((AbstractInsnNode) o);
        }
        this.previousInsn = (AbstractInsnNode) o;
        this.remove = null;
    }

    @Override // java.util.ListIterator
    public void set(Object o) {
        if (this.remove != null) {
            this.this$0.set(this.remove, (AbstractInsnNode) o);
            if (this.remove == this.previousInsn) {
                this.previousInsn = (AbstractInsnNode) o;
                return;
            } else {
                this.nextInsn = (AbstractInsnNode) o;
                return;
            }
        }
        throw new IllegalStateException();
    }
}
