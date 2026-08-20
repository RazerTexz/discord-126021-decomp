package org.objectweb.asm.commons;

import java.util.ArrayList;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.signature.SignatureVisitor;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/commons/SignatureRemapper.SCL.lombok */
public class SignatureRemapper extends SignatureVisitor {
    private final SignatureVisitor signatureVisitor;
    private final Remapper remapper;
    private ArrayList<String> classNames;

    public SignatureRemapper(SignatureVisitor signatureVisitor, Remapper remapper) {
        this(Opcodes.ASM9, signatureVisitor, remapper);
    }

    protected SignatureRemapper(int api, SignatureVisitor signatureVisitor, Remapper remapper) {
        super(api);
        this.classNames = new ArrayList<>();
        this.signatureVisitor = signatureVisitor;
        this.remapper = remapper;
    }

    @Override // org.objectweb.asm.signature.SignatureVisitor
    public void visitClassType(String name) {
        this.classNames.add(name);
        this.signatureVisitor.visitClassType(this.remapper.mapType(name));
    }

    @Override // org.objectweb.asm.signature.SignatureVisitor
    public void visitInnerClassType(String name) {
        int iLastIndexOf;
        String outerClassName = this.classNames.remove(this.classNames.size() - 1);
        String className = outerClassName + '$' + name;
        this.classNames.add(className);
        String remappedOuter = this.remapper.mapType(outerClassName) + '$';
        String remappedName = this.remapper.mapType(className);
        if (remappedName.startsWith(remappedOuter)) {
            iLastIndexOf = remappedOuter.length();
        } else {
            iLastIndexOf = remappedName.lastIndexOf(36) + 1;
        }
        int index = iLastIndexOf;
        this.signatureVisitor.visitInnerClassType(remappedName.substring(index));
    }

    @Override // org.objectweb.asm.signature.SignatureVisitor
    public void visitFormalTypeParameter(String name) {
        this.signatureVisitor.visitFormalTypeParameter(name);
    }

    @Override // org.objectweb.asm.signature.SignatureVisitor
    public void visitTypeVariable(String name) {
        this.signatureVisitor.visitTypeVariable(name);
    }

    @Override // org.objectweb.asm.signature.SignatureVisitor
    public SignatureVisitor visitArrayType() {
        this.signatureVisitor.visitArrayType();
        return this;
    }

    @Override // org.objectweb.asm.signature.SignatureVisitor
    public void visitBaseType(char descriptor) {
        this.signatureVisitor.visitBaseType(descriptor);
    }

    @Override // org.objectweb.asm.signature.SignatureVisitor
    public SignatureVisitor visitClassBound() {
        this.signatureVisitor.visitClassBound();
        return this;
    }

    @Override // org.objectweb.asm.signature.SignatureVisitor
    public SignatureVisitor visitExceptionType() {
        this.signatureVisitor.visitExceptionType();
        return this;
    }

    @Override // org.objectweb.asm.signature.SignatureVisitor
    public SignatureVisitor visitInterface() {
        this.signatureVisitor.visitInterface();
        return this;
    }

    @Override // org.objectweb.asm.signature.SignatureVisitor
    public SignatureVisitor visitInterfaceBound() {
        this.signatureVisitor.visitInterfaceBound();
        return this;
    }

    @Override // org.objectweb.asm.signature.SignatureVisitor
    public SignatureVisitor visitParameterType() {
        this.signatureVisitor.visitParameterType();
        return this;
    }

    @Override // org.objectweb.asm.signature.SignatureVisitor
    public SignatureVisitor visitReturnType() {
        this.signatureVisitor.visitReturnType();
        return this;
    }

    @Override // org.objectweb.asm.signature.SignatureVisitor
    public SignatureVisitor visitSuperclass() {
        this.signatureVisitor.visitSuperclass();
        return this;
    }

    @Override // org.objectweb.asm.signature.SignatureVisitor
    public void visitTypeArgument() {
        this.signatureVisitor.visitTypeArgument();
    }

    @Override // org.objectweb.asm.signature.SignatureVisitor
    public SignatureVisitor visitTypeArgument(char wildcard) {
        this.signatureVisitor.visitTypeArgument(wildcard);
        return this;
    }

    @Override // org.objectweb.asm.signature.SignatureVisitor
    public void visitEnd() {
        this.signatureVisitor.visitEnd();
        this.classNames.remove(this.classNames.size() - 1);
    }
}
