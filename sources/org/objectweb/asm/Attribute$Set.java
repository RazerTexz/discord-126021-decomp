package org.objectweb.asm;

/* JADX INFO: loaded from: app.apk:org/objectweb/asm/Attribute$Set.SCL.lombok */
final class Attribute$Set {
    private static final int SIZE_INCREMENT = 6;
    private int size;
    private Attribute[] data = new Attribute[6];

    Attribute$Set() {
    }

    void addAttributes(Attribute attributeList) {
        Attribute attribute = attributeList;
        while (true) {
            Attribute attribute2 = attribute;
            if (attribute2 != null) {
                if (!contains(attribute2)) {
                    add(attribute2);
                }
                attribute = attribute2.nextAttribute;
            } else {
                return;
            }
        }
    }

    Attribute[] toArray() {
        Attribute[] result = new Attribute[this.size];
        System.arraycopy(this.data, 0, result, 0, this.size);
        return result;
    }

    private boolean contains(Attribute attribute) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i].type.equals(attribute.type)) {
                return true;
            }
        }
        return false;
    }

    private void add(Attribute attribute) {
        if (this.size >= this.data.length) {
            Attribute[] newData = new Attribute[this.data.length + 6];
            System.arraycopy(this.data, 0, newData, 0, this.size);
            this.data = newData;
        }
        Attribute[] attributeArr = this.data;
        int i = this.size;
        this.size = i + 1;
        attributeArr[i] = attribute;
    }
}
