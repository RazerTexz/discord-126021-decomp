package org.objectweb.asm.signature;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/signature/SignatureReader.SCL.lombok */
public class SignatureReader {
    private final String signatureValue;

    public SignatureReader(String signature) {
        this.signatureValue = signature;
    }

    public void accept(SignatureVisitor signatureVistor) {
        int offset;
        char currentChar;
        String signature = this.signatureValue;
        int length = signature.length();
        if (signature.charAt(0) == '<') {
            offset = 2;
            do {
                int classBoundStartOffset = signature.indexOf(58, offset);
                signatureVistor.visitFormalTypeParameter(signature.substring(offset - 1, classBoundStartOffset));
                int offset2 = classBoundStartOffset + 1;
                char currentChar2 = signature.charAt(offset2);
                if (currentChar2 == 'L' || currentChar2 == '[' || currentChar2 == 'T') {
                    offset2 = parseType(signature, offset2, signatureVistor.visitClassBound());
                }
                while (true) {
                    int i = offset2;
                    offset = offset2 + 1;
                    currentChar = signature.charAt(i);
                    if (currentChar != ':') {
                        break;
                    } else {
                        offset2 = parseType(signature, offset, signatureVistor.visitInterfaceBound());
                    }
                }
            } while (currentChar != '>');
        } else {
            offset = 0;
        }
        if (signature.charAt(offset) == '(') {
            int offset3 = offset + 1;
            while (signature.charAt(offset3) != ')') {
                offset3 = parseType(signature, offset3, signatureVistor.visitParameterType());
            }
            int type = parseType(signature, offset3 + 1, signatureVistor.visitReturnType());
            while (true) {
                int offset4 = type;
                if (offset4 < length) {
                    type = parseType(signature, offset4 + 1, signatureVistor.visitExceptionType());
                } else {
                    return;
                }
            }
        } else {
            int type2 = parseType(signature, offset, signatureVistor.visitSuperclass());
            while (true) {
                int offset5 = type2;
                if (offset5 < length) {
                    type2 = parseType(signature, offset5, signatureVistor.visitInterface());
                } else {
                    return;
                }
            }
        }
    }

    public void acceptType(SignatureVisitor signatureVisitor) {
        parseType(this.signatureValue, 0, signatureVisitor);
    }

    private static int parseType(String signature, int startOffset, SignatureVisitor signatureVisitor) {
        int offset = startOffset + 1;
        char currentChar = signature.charAt(startOffset);
        switch (currentChar) {
            case 'B':
            case 'C':
            case 'D':
            case 'F':
            case 'I':
            case 'J':
            case 'S':
            case 'V':
            case 'Z':
                signatureVisitor.visitBaseType(currentChar);
                return offset;
            case 'E':
            case 'G':
            case 'H':
            case 'K':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'U':
            case 'W':
            case 'X':
            case 'Y':
            default:
                throw new IllegalArgumentException();
            case 'L':
                int start = offset;
                boolean visited = false;
                boolean inner = false;
                while (true) {
                    int i = offset;
                    offset++;
                    char currentChar2 = signature.charAt(i);
                    if (currentChar2 == '.' || currentChar2 == ';') {
                        if (!visited) {
                            String name = signature.substring(start, offset - 1);
                            if (inner) {
                                signatureVisitor.visitInnerClassType(name);
                            } else {
                                signatureVisitor.visitClassType(name);
                            }
                        }
                        if (currentChar2 == ';') {
                            signatureVisitor.visitEnd();
                            return offset;
                        }
                        start = offset;
                        visited = false;
                        inner = true;
                    } else if (currentChar2 == '<') {
                        String name2 = signature.substring(start, offset - 1);
                        if (inner) {
                            signatureVisitor.visitInnerClassType(name2);
                        } else {
                            signatureVisitor.visitClassType(name2);
                        }
                        visited = true;
                        while (true) {
                            char currentChar3 = signature.charAt(offset);
                            if (currentChar3 != '>') {
                                switch (currentChar3) {
                                    case '*':
                                        offset++;
                                        signatureVisitor.visitTypeArgument();
                                        break;
                                    case '+':
                                    case '-':
                                        offset = parseType(signature, offset + 1, signatureVisitor.visitTypeArgument(currentChar3));
                                        break;
                                    case ',':
                                    default:
                                        offset = parseType(signature, offset, signatureVisitor.visitTypeArgument('='));
                                        break;
                                }
                            }
                        }
                    }
                }
                break;
            case 'T':
                int endOffset = signature.indexOf(59, offset);
                signatureVisitor.visitTypeVariable(signature.substring(offset, endOffset));
                return endOffset + 1;
            case '[':
                return parseType(signature, offset, signatureVisitor.visitArrayType());
        }
    }
}
