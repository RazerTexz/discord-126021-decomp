package org.objectweb.asm;

import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.discord.widgets.chat.input.MentionUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: app.apk:org/objectweb/asm/ClassReader.SCL.lombok */
public class ClassReader {
    public static final int SKIP_CODE = 1;
    public static final int SKIP_DEBUG = 2;
    public static final int SKIP_FRAMES = 4;
    public static final int EXPAND_FRAMES = 8;
    static final int EXPAND_ASM_INSNS = 256;
    private static final int INPUT_STREAM_DATA_CHUNK_SIZE = 4096;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public final byte[] f3818b;
    public final int header;
    final byte[] classFileBuffer;
    private final int[] cpInfoOffsets;
    private final String[] constantUtf8Values;
    private final ConstantDynamic[] constantDynamicValues;
    private final int[] bootstrapMethodOffsets;
    private final int maxStringLength;

    public ClassReader(byte[] classFile) {
        this(classFile, 0, classFile.length);
    }

    public ClassReader(byte[] classFileBuffer, int classFileOffset, int classFileLength) {
        this(classFileBuffer, classFileOffset, true);
    }

    ClassReader(byte[] classFileBuffer, int classFileOffset, boolean checkClassVersion) {
        int cpInfoSize;
        this.classFileBuffer = classFileBuffer;
        this.f3818b = classFileBuffer;
        if (checkClassVersion && readShort(classFileOffset + 6) > 60) {
            throw new IllegalArgumentException("Unsupported class file major version " + ((int) readShort(classFileOffset + 6)));
        }
        int constantPoolCount = readUnsignedShort(classFileOffset + 8);
        this.cpInfoOffsets = new int[constantPoolCount];
        this.constantUtf8Values = new String[constantPoolCount];
        int currentCpInfoIndex = 1;
        int currentCpInfoOffset = classFileOffset + 10;
        int currentMaxStringLength = 0;
        boolean hasBootstrapMethods = false;
        boolean hasConstantDynamic = false;
        while (currentCpInfoIndex < constantPoolCount) {
            int i = currentCpInfoIndex;
            currentCpInfoIndex++;
            this.cpInfoOffsets[i] = currentCpInfoOffset + 1;
            switch (classFileBuffer[currentCpInfoOffset]) {
                case 1:
                    cpInfoSize = 3 + readUnsignedShort(currentCpInfoOffset + 1);
                    if (cpInfoSize > currentMaxStringLength) {
                        currentMaxStringLength = cpInfoSize;
                    }
                    break;
                case 2:
                case 13:
                case 14:
                default:
                    throw new IllegalArgumentException();
                case 3:
                case 4:
                case 9:
                case 10:
                case 11:
                case 12:
                    cpInfoSize = 5;
                    break;
                case 5:
                case 6:
                    cpInfoSize = 9;
                    currentCpInfoIndex++;
                    break;
                case 7:
                case 8:
                case 16:
                case 19:
                case 20:
                    cpInfoSize = 3;
                    break;
                case 15:
                    cpInfoSize = 4;
                    break;
                case 17:
                    cpInfoSize = 5;
                    hasBootstrapMethods = true;
                    hasConstantDynamic = true;
                    break;
                case 18:
                    cpInfoSize = 5;
                    hasBootstrapMethods = true;
                    break;
            }
            currentCpInfoOffset += cpInfoSize;
        }
        this.maxStringLength = currentMaxStringLength;
        this.header = currentCpInfoOffset;
        this.constantDynamicValues = hasConstantDynamic ? new ConstantDynamic[constantPoolCount] : null;
        this.bootstrapMethodOffsets = hasBootstrapMethods ? readBootstrapMethodsAttribute(currentMaxStringLength) : null;
    }

    public ClassReader(InputStream inputStream) throws IOException {
        this(readStream(inputStream, false));
    }

    public ClassReader(String className) throws IOException {
        this(readStream(ClassLoader.getSystemResourceAsStream(className.replace('.', MentionUtils.SLASH_CHAR) + ".class"), true));
    }

    /* JADX WARN: Code duplicated, block: B:30:0x007b  */
    /* JADX WARN: Code duplicated, block: B:35:0x008f A[Catch: all -> 0x0096, TryCatch #2 {all -> 0x0096, blocks: (B:6:0x000e, B:7:0x0018, B:8:0x001f, B:10:0x0030, B:11:0x003c, B:15:0x004e, B:18:0x005e, B:26:0x0074, B:32:0x007f, B:35:0x008f, B:37:0x0095), top: B:47:0x000e, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private static byte[] readStream(InputStream inputStream, boolean close) throws IOException {
        if (inputStream == null) {
            throw new IOException("Class not found");
        }
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            Throwable th = null;
            try {
                try {
                    byte[] data = new byte[4096];
                    while (true) {
                        int bytesRead = inputStream.read(data, 0, data.length);
                        if (bytesRead == -1) {
                            break;
                        }
                        outputStream.write(data, 0, bytesRead);
                        if (outputStream != null) {
                            if (th != null) {
                                try {
                                    outputStream.close();
                                } catch (Throwable th2) {
                                }
                            } else {
                                outputStream.close();
                            }
                        }
                        throw th;
                    }
                    outputStream.flush();
                    byte[] byteArray = outputStream.toByteArray();
                    if (outputStream != null) {
                        if (0 != 0) {
                            try {
                                outputStream.close();
                            } catch (Throwable th3) {
                            }
                        } else {
                            outputStream.close();
                        }
                    }
                    if (close) {
                        inputStream.close();
                    }
                    return byteArray;
                } catch (Throwable th4) {
                    th = th4;
                    throw th4;
                }
            } catch (Throwable th5) {
                if (outputStream != null) {
                    if (th != null) {
                        outputStream.close();
                    } else {
                        outputStream.close();
                    }
                }
                throw th5;
            }
        } catch (Throwable th6) {
            if (close) {
                inputStream.close();
            }
            throw th6;
        }
    }

    public int getAccess() {
        return readUnsignedShort(this.header);
    }

    public String getClassName() {
        return readClass(this.header + 2, new char[this.maxStringLength]);
    }

    public String getSuperName() {
        return readClass(this.header + 4, new char[this.maxStringLength]);
    }

    public String[] getInterfaces() {
        int currentOffset = this.header + 6;
        int interfacesCount = readUnsignedShort(currentOffset);
        String[] interfaces = new String[interfacesCount];
        if (interfacesCount > 0) {
            char[] charBuffer = new char[this.maxStringLength];
            for (int i = 0; i < interfacesCount; i++) {
                currentOffset += 2;
                interfaces[i] = readClass(currentOffset, charBuffer);
            }
        }
        return interfaces;
    }

    public void accept(ClassVisitor classVisitor, int parsingOptions) {
        accept(classVisitor, new Attribute[0], parsingOptions);
    }

    public void accept(ClassVisitor classVisitor, Attribute[] attributePrototypes, int parsingOptions) {
        Context context = new Context();
        context.attributePrototypes = attributePrototypes;
        context.parsingOptions = parsingOptions;
        context.charBuffer = new char[this.maxStringLength];
        char[] charBuffer = context.charBuffer;
        int currentOffset = this.header;
        int accessFlags = readUnsignedShort(currentOffset);
        String thisClass = readClass(currentOffset + 2, charBuffer);
        String superClass = readClass(currentOffset + 4, charBuffer);
        String[] interfaces = new String[readUnsignedShort(currentOffset + 6)];
        int currentOffset2 = currentOffset + 8;
        for (int i = 0; i < interfaces.length; i++) {
            interfaces[i] = readClass(currentOffset2, charBuffer);
            currentOffset2 += 2;
        }
        int innerClassesOffset = 0;
        int enclosingMethodOffset = 0;
        String signature = null;
        String sourceFile = null;
        String sourceDebugExtension = null;
        int runtimeVisibleAnnotationsOffset = 0;
        int runtimeInvisibleAnnotationsOffset = 0;
        int runtimeVisibleTypeAnnotationsOffset = 0;
        int runtimeInvisibleTypeAnnotationsOffset = 0;
        int moduleOffset = 0;
        int modulePackagesOffset = 0;
        String moduleMainClass = null;
        String nestHostClass = null;
        int nestMembersOffset = 0;
        int permittedSubclassesOffset = 0;
        int recordOffset = 0;
        Attribute attributes = null;
        int currentAttributeOffset = getFirstAttributeOffset();
        for (int i2 = readUnsignedShort(currentAttributeOffset - 2); i2 > 0; i2--) {
            String attributeName = readUTF8(currentAttributeOffset, charBuffer);
            int attributeLength = readInt(currentAttributeOffset + 2);
            int currentAttributeOffset2 = currentAttributeOffset + 6;
            if ("SourceFile".equals(attributeName)) {
                sourceFile = readUTF8(currentAttributeOffset2, charBuffer);
            } else if ("InnerClasses".equals(attributeName)) {
                innerClassesOffset = currentAttributeOffset2;
            } else if ("EnclosingMethod".equals(attributeName)) {
                enclosingMethodOffset = currentAttributeOffset2;
            } else if ("NestHost".equals(attributeName)) {
                nestHostClass = readClass(currentAttributeOffset2, charBuffer);
            } else if ("NestMembers".equals(attributeName)) {
                nestMembersOffset = currentAttributeOffset2;
            } else if ("PermittedSubclasses".equals(attributeName)) {
                permittedSubclassesOffset = currentAttributeOffset2;
            } else if ("Signature".equals(attributeName)) {
                signature = readUTF8(currentAttributeOffset2, charBuffer);
            } else if ("RuntimeVisibleAnnotations".equals(attributeName)) {
                runtimeVisibleAnnotationsOffset = currentAttributeOffset2;
            } else if ("RuntimeVisibleTypeAnnotations".equals(attributeName)) {
                runtimeVisibleTypeAnnotationsOffset = currentAttributeOffset2;
            } else if ("Deprecated".equals(attributeName)) {
                accessFlags |= 131072;
            } else if ("Synthetic".equals(attributeName)) {
                accessFlags |= 4096;
            } else if ("SourceDebugExtension".equals(attributeName)) {
                sourceDebugExtension = readUtf(currentAttributeOffset2, attributeLength, new char[attributeLength]);
            } else if ("RuntimeInvisibleAnnotations".equals(attributeName)) {
                runtimeInvisibleAnnotationsOffset = currentAttributeOffset2;
            } else if ("RuntimeInvisibleTypeAnnotations".equals(attributeName)) {
                runtimeInvisibleTypeAnnotationsOffset = currentAttributeOffset2;
            } else if ("Record".equals(attributeName)) {
                recordOffset = currentAttributeOffset2;
                accessFlags |= 65536;
            } else if ("Module".equals(attributeName)) {
                moduleOffset = currentAttributeOffset2;
            } else if ("ModuleMainClass".equals(attributeName)) {
                moduleMainClass = readClass(currentAttributeOffset2, charBuffer);
            } else if ("ModulePackages".equals(attributeName)) {
                modulePackagesOffset = currentAttributeOffset2;
            } else if (!"BootstrapMethods".equals(attributeName)) {
                Attribute attribute = readAttribute(attributePrototypes, attributeName, currentAttributeOffset2, attributeLength, charBuffer, -1, null);
                attribute.nextAttribute = attributes;
                attributes = attribute;
            }
            currentAttributeOffset = currentAttributeOffset2 + attributeLength;
        }
        classVisitor.visit(readInt(this.cpInfoOffsets[1] - 7), accessFlags, thisClass, signature, superClass, interfaces);
        if ((parsingOptions & 2) == 0 && (sourceFile != null || sourceDebugExtension != null)) {
            classVisitor.visitSource(sourceFile, sourceDebugExtension);
        }
        if (moduleOffset != 0) {
            readModuleAttributes(classVisitor, context, moduleOffset, modulePackagesOffset, moduleMainClass);
        }
        if (nestHostClass != null) {
            classVisitor.visitNestHost(nestHostClass);
        }
        if (enclosingMethodOffset != 0) {
            String className = readClass(enclosingMethodOffset, charBuffer);
            int methodIndex = readUnsignedShort(enclosingMethodOffset + 2);
            String name = methodIndex == 0 ? null : readUTF8(this.cpInfoOffsets[methodIndex], charBuffer);
            String type = methodIndex == 0 ? null : readUTF8(this.cpInfoOffsets[methodIndex] + 2, charBuffer);
            classVisitor.visitOuterClass(className, name, type);
        }
        if (runtimeVisibleAnnotationsOffset != 0) {
            int numAnnotations = readUnsignedShort(runtimeVisibleAnnotationsOffset);
            int elementValues = runtimeVisibleAnnotationsOffset + 2;
            while (true) {
                int currentAnnotationOffset = elementValues;
                int i3 = numAnnotations;
                numAnnotations--;
                if (i3 <= 0) {
                    break;
                }
                String annotationDescriptor = readUTF8(currentAnnotationOffset, charBuffer);
                elementValues = readElementValues(classVisitor.visitAnnotation(annotationDescriptor, true), currentAnnotationOffset + 2, true, charBuffer);
            }
        }
        if (runtimeInvisibleAnnotationsOffset != 0) {
            int numAnnotations2 = readUnsignedShort(runtimeInvisibleAnnotationsOffset);
            int elementValues2 = runtimeInvisibleAnnotationsOffset + 2;
            while (true) {
                int currentAnnotationOffset2 = elementValues2;
                int i4 = numAnnotations2;
                numAnnotations2--;
                if (i4 <= 0) {
                    break;
                }
                String annotationDescriptor2 = readUTF8(currentAnnotationOffset2, charBuffer);
                elementValues2 = readElementValues(classVisitor.visitAnnotation(annotationDescriptor2, false), currentAnnotationOffset2 + 2, true, charBuffer);
            }
        }
        if (runtimeVisibleTypeAnnotationsOffset != 0) {
            int numAnnotations3 = readUnsignedShort(runtimeVisibleTypeAnnotationsOffset);
            int elementValues3 = runtimeVisibleTypeAnnotationsOffset + 2;
            while (true) {
                int currentAnnotationOffset3 = elementValues3;
                int i5 = numAnnotations3;
                numAnnotations3--;
                if (i5 <= 0) {
                    break;
                }
                int currentAnnotationOffset4 = readTypeAnnotationTarget(context, currentAnnotationOffset3);
                String annotationDescriptor3 = readUTF8(currentAnnotationOffset4, charBuffer);
                elementValues3 = readElementValues(classVisitor.visitTypeAnnotation(context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath, annotationDescriptor3, true), currentAnnotationOffset4 + 2, true, charBuffer);
            }
        }
        if (runtimeInvisibleTypeAnnotationsOffset != 0) {
            int numAnnotations4 = readUnsignedShort(runtimeInvisibleTypeAnnotationsOffset);
            int elementValues4 = runtimeInvisibleTypeAnnotationsOffset + 2;
            while (true) {
                int currentAnnotationOffset5 = elementValues4;
                int i6 = numAnnotations4;
                numAnnotations4--;
                if (i6 <= 0) {
                    break;
                }
                int currentAnnotationOffset6 = readTypeAnnotationTarget(context, currentAnnotationOffset5);
                String annotationDescriptor4 = readUTF8(currentAnnotationOffset6, charBuffer);
                elementValues4 = readElementValues(classVisitor.visitTypeAnnotation(context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath, annotationDescriptor4, false), currentAnnotationOffset6 + 2, true, charBuffer);
            }
        }
        while (attributes != null) {
            Attribute nextAttribute = attributes.nextAttribute;
            attributes.nextAttribute = null;
            classVisitor.visitAttribute(attributes);
            attributes = nextAttribute;
        }
        if (nestMembersOffset != 0) {
            int numberOfNestMembers = readUnsignedShort(nestMembersOffset);
            int currentNestMemberOffset = nestMembersOffset + 2;
            while (true) {
                int i7 = numberOfNestMembers;
                numberOfNestMembers--;
                if (i7 <= 0) {
                    break;
                }
                classVisitor.visitNestMember(readClass(currentNestMemberOffset, charBuffer));
                currentNestMemberOffset += 2;
            }
        }
        if (permittedSubclassesOffset != 0) {
            int numberOfPermittedSubclasses = readUnsignedShort(permittedSubclassesOffset);
            int currentPermittedSubclassesOffset = permittedSubclassesOffset + 2;
            while (true) {
                int i8 = numberOfPermittedSubclasses;
                numberOfPermittedSubclasses--;
                if (i8 <= 0) {
                    break;
                }
                classVisitor.visitPermittedSubclass(readClass(currentPermittedSubclassesOffset, charBuffer));
                currentPermittedSubclassesOffset += 2;
            }
        }
        if (innerClassesOffset != 0) {
            int numberOfClasses = readUnsignedShort(innerClassesOffset);
            int currentClassesOffset = innerClassesOffset + 2;
            while (true) {
                int i9 = numberOfClasses;
                numberOfClasses--;
                if (i9 <= 0) {
                    break;
                }
                classVisitor.visitInnerClass(readClass(currentClassesOffset, charBuffer), readClass(currentClassesOffset + 2, charBuffer), readUTF8(currentClassesOffset + 4, charBuffer), readUnsignedShort(currentClassesOffset + 6));
                currentClassesOffset += 8;
            }
        }
        if (recordOffset != 0) {
            int recordComponentsCount = readUnsignedShort(recordOffset);
            int recordOffset2 = recordOffset + 2;
            while (true) {
                int i10 = recordComponentsCount;
                recordComponentsCount--;
                if (i10 <= 0) {
                    break;
                } else {
                    recordOffset2 = readRecordComponent(classVisitor, context, recordOffset2);
                }
            }
        }
        int fieldsCount = readUnsignedShort(currentOffset2);
        int currentOffset3 = currentOffset2 + 2;
        while (true) {
            int i11 = fieldsCount;
            fieldsCount--;
            if (i11 <= 0) {
                break;
            } else {
                currentOffset3 = readField(classVisitor, context, currentOffset3);
            }
        }
        int methodsCount = readUnsignedShort(currentOffset3);
        int currentOffset4 = currentOffset3 + 2;
        while (true) {
            int i12 = methodsCount;
            methodsCount--;
            if (i12 > 0) {
                currentOffset4 = readMethod(classVisitor, context, currentOffset4);
            } else {
                classVisitor.visitEnd();
                return;
            }
        }
    }

    private void readModuleAttributes(ClassVisitor classVisitor, Context context, int moduleOffset, int modulePackagesOffset, String moduleMainClass) {
        char[] buffer = context.charBuffer;
        String moduleName = readModule(moduleOffset, buffer);
        int moduleFlags = readUnsignedShort(moduleOffset + 2);
        String moduleVersion = readUTF8(moduleOffset + 4, buffer);
        int currentOffset = moduleOffset + 6;
        ModuleVisitor moduleVisitor = classVisitor.visitModule(moduleName, moduleFlags, moduleVersion);
        if (moduleVisitor == null) {
            return;
        }
        if (moduleMainClass != null) {
            moduleVisitor.visitMainClass(moduleMainClass);
        }
        if (modulePackagesOffset != 0) {
            int packageCount = readUnsignedShort(modulePackagesOffset);
            int currentPackageOffset = modulePackagesOffset + 2;
            while (true) {
                int i = packageCount;
                packageCount--;
                if (i <= 0) {
                    break;
                }
                moduleVisitor.visitPackage(readPackage(currentPackageOffset, buffer));
                currentPackageOffset += 2;
            }
        }
        int requiresCount = readUnsignedShort(currentOffset);
        int currentOffset2 = currentOffset + 2;
        while (true) {
            int i2 = requiresCount;
            requiresCount--;
            if (i2 <= 0) {
                break;
            }
            String requires = readModule(currentOffset2, buffer);
            int requiresFlags = readUnsignedShort(currentOffset2 + 2);
            String requiresVersion = readUTF8(currentOffset2 + 4, buffer);
            currentOffset2 += 6;
            moduleVisitor.visitRequire(requires, requiresFlags, requiresVersion);
        }
        int exportsCount = readUnsignedShort(currentOffset2);
        int currentOffset3 = currentOffset2 + 2;
        while (true) {
            int i3 = exportsCount;
            exportsCount--;
            if (i3 <= 0) {
                break;
            }
            String exports = readPackage(currentOffset3, buffer);
            int exportsFlags = readUnsignedShort(currentOffset3 + 2);
            int exportsToCount = readUnsignedShort(currentOffset3 + 4);
            currentOffset3 += 6;
            String[] exportsTo = null;
            if (exportsToCount != 0) {
                exportsTo = new String[exportsToCount];
                for (int i4 = 0; i4 < exportsToCount; i4++) {
                    exportsTo[i4] = readModule(currentOffset3, buffer);
                    currentOffset3 += 2;
                }
            }
            moduleVisitor.visitExport(exports, exportsFlags, exportsTo);
        }
        int opensCount = readUnsignedShort(currentOffset3);
        int currentOffset4 = currentOffset3 + 2;
        while (true) {
            int i5 = opensCount;
            opensCount--;
            if (i5 <= 0) {
                break;
            }
            String opens = readPackage(currentOffset4, buffer);
            int opensFlags = readUnsignedShort(currentOffset4 + 2);
            int opensToCount = readUnsignedShort(currentOffset4 + 4);
            currentOffset4 += 6;
            String[] opensTo = null;
            if (opensToCount != 0) {
                opensTo = new String[opensToCount];
                for (int i6 = 0; i6 < opensToCount; i6++) {
                    opensTo[i6] = readModule(currentOffset4, buffer);
                    currentOffset4 += 2;
                }
            }
            moduleVisitor.visitOpen(opens, opensFlags, opensTo);
        }
        int usesCount = readUnsignedShort(currentOffset4);
        while (true) {
            currentOffset4 += 2;
            int i7 = usesCount;
            usesCount--;
            if (i7 <= 0) {
                break;
            } else {
                moduleVisitor.visitUse(readClass(currentOffset4, buffer));
            }
        }
        int providesCount = readUnsignedShort(currentOffset4);
        int currentOffset5 = currentOffset4 + 2;
        while (true) {
            int i8 = providesCount;
            providesCount--;
            if (i8 > 0) {
                String provides = readClass(currentOffset5, buffer);
                int providesWithCount = readUnsignedShort(currentOffset5 + 2);
                currentOffset5 += 4;
                String[] providesWith = new String[providesWithCount];
                for (int i9 = 0; i9 < providesWithCount; i9++) {
                    providesWith[i9] = readClass(currentOffset5, buffer);
                    currentOffset5 += 2;
                }
                moduleVisitor.visitProvide(provides, providesWith);
            } else {
                moduleVisitor.visitEnd();
                return;
            }
        }
    }

    private int readRecordComponent(ClassVisitor classVisitor, Context context, int recordComponentOffset) {
        char[] charBuffer = context.charBuffer;
        String name = readUTF8(recordComponentOffset, charBuffer);
        String descriptor = readUTF8(recordComponentOffset + 2, charBuffer);
        int currentOffset = recordComponentOffset + 4;
        String signature = null;
        int runtimeVisibleAnnotationsOffset = 0;
        int runtimeInvisibleAnnotationsOffset = 0;
        int runtimeVisibleTypeAnnotationsOffset = 0;
        int runtimeInvisibleTypeAnnotationsOffset = 0;
        Attribute attributes = null;
        int attributesCount = readUnsignedShort(currentOffset);
        int currentOffset2 = currentOffset + 2;
        while (true) {
            int i = attributesCount;
            attributesCount--;
            if (i <= 0) {
                break;
            }
            String attributeName = readUTF8(currentOffset2, charBuffer);
            int attributeLength = readInt(currentOffset2 + 2);
            int currentOffset3 = currentOffset2 + 6;
            if ("Signature".equals(attributeName)) {
                signature = readUTF8(currentOffset3, charBuffer);
            } else if ("RuntimeVisibleAnnotations".equals(attributeName)) {
                runtimeVisibleAnnotationsOffset = currentOffset3;
            } else if ("RuntimeVisibleTypeAnnotations".equals(attributeName)) {
                runtimeVisibleTypeAnnotationsOffset = currentOffset3;
            } else if ("RuntimeInvisibleAnnotations".equals(attributeName)) {
                runtimeInvisibleAnnotationsOffset = currentOffset3;
            } else if ("RuntimeInvisibleTypeAnnotations".equals(attributeName)) {
                runtimeInvisibleTypeAnnotationsOffset = currentOffset3;
            } else {
                Attribute attribute = readAttribute(context.attributePrototypes, attributeName, currentOffset3, attributeLength, charBuffer, -1, null);
                attribute.nextAttribute = attributes;
                attributes = attribute;
            }
            currentOffset2 = currentOffset3 + attributeLength;
        }
        RecordComponentVisitor recordComponentVisitor = classVisitor.visitRecordComponent(name, descriptor, signature);
        if (recordComponentVisitor == null) {
            return currentOffset2;
        }
        if (runtimeVisibleAnnotationsOffset != 0) {
            int numAnnotations = readUnsignedShort(runtimeVisibleAnnotationsOffset);
            int elementValues = runtimeVisibleAnnotationsOffset + 2;
            while (true) {
                int currentAnnotationOffset = elementValues;
                int i2 = numAnnotations;
                numAnnotations--;
                if (i2 <= 0) {
                    break;
                }
                String annotationDescriptor = readUTF8(currentAnnotationOffset, charBuffer);
                elementValues = readElementValues(recordComponentVisitor.visitAnnotation(annotationDescriptor, true), currentAnnotationOffset + 2, true, charBuffer);
            }
        }
        if (runtimeInvisibleAnnotationsOffset != 0) {
            int numAnnotations2 = readUnsignedShort(runtimeInvisibleAnnotationsOffset);
            int elementValues2 = runtimeInvisibleAnnotationsOffset + 2;
            while (true) {
                int currentAnnotationOffset2 = elementValues2;
                int i3 = numAnnotations2;
                numAnnotations2--;
                if (i3 <= 0) {
                    break;
                }
                String annotationDescriptor2 = readUTF8(currentAnnotationOffset2, charBuffer);
                elementValues2 = readElementValues(recordComponentVisitor.visitAnnotation(annotationDescriptor2, false), currentAnnotationOffset2 + 2, true, charBuffer);
            }
        }
        if (runtimeVisibleTypeAnnotationsOffset != 0) {
            int numAnnotations3 = readUnsignedShort(runtimeVisibleTypeAnnotationsOffset);
            int elementValues3 = runtimeVisibleTypeAnnotationsOffset + 2;
            while (true) {
                int currentAnnotationOffset3 = elementValues3;
                int i4 = numAnnotations3;
                numAnnotations3--;
                if (i4 <= 0) {
                    break;
                }
                int currentAnnotationOffset4 = readTypeAnnotationTarget(context, currentAnnotationOffset3);
                String annotationDescriptor3 = readUTF8(currentAnnotationOffset4, charBuffer);
                elementValues3 = readElementValues(recordComponentVisitor.visitTypeAnnotation(context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath, annotationDescriptor3, true), currentAnnotationOffset4 + 2, true, charBuffer);
            }
        }
        if (runtimeInvisibleTypeAnnotationsOffset != 0) {
            int numAnnotations4 = readUnsignedShort(runtimeInvisibleTypeAnnotationsOffset);
            int elementValues4 = runtimeInvisibleTypeAnnotationsOffset + 2;
            while (true) {
                int currentAnnotationOffset5 = elementValues4;
                int i5 = numAnnotations4;
                numAnnotations4--;
                if (i5 <= 0) {
                    break;
                }
                int currentAnnotationOffset6 = readTypeAnnotationTarget(context, currentAnnotationOffset5);
                String annotationDescriptor4 = readUTF8(currentAnnotationOffset6, charBuffer);
                elementValues4 = readElementValues(recordComponentVisitor.visitTypeAnnotation(context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath, annotationDescriptor4, false), currentAnnotationOffset6 + 2, true, charBuffer);
            }
        }
        while (attributes != null) {
            Attribute nextAttribute = attributes.nextAttribute;
            attributes.nextAttribute = null;
            recordComponentVisitor.visitAttribute(attributes);
            attributes = nextAttribute;
        }
        recordComponentVisitor.visitEnd();
        return currentOffset2;
    }

    private int readField(ClassVisitor classVisitor, Context context, int fieldInfoOffset) {
        char[] charBuffer = context.charBuffer;
        int accessFlags = readUnsignedShort(fieldInfoOffset);
        String name = readUTF8(fieldInfoOffset + 2, charBuffer);
        String descriptor = readUTF8(fieldInfoOffset + 4, charBuffer);
        int currentOffset = fieldInfoOffset + 6;
        Object constantValue = null;
        String signature = null;
        int runtimeVisibleAnnotationsOffset = 0;
        int runtimeInvisibleAnnotationsOffset = 0;
        int runtimeVisibleTypeAnnotationsOffset = 0;
        int runtimeInvisibleTypeAnnotationsOffset = 0;
        Attribute attributes = null;
        int attributesCount = readUnsignedShort(currentOffset);
        int currentOffset2 = currentOffset + 2;
        while (true) {
            int i = attributesCount;
            attributesCount--;
            if (i <= 0) {
                break;
            }
            String attributeName = readUTF8(currentOffset2, charBuffer);
            int attributeLength = readInt(currentOffset2 + 2);
            int currentOffset3 = currentOffset2 + 6;
            if ("ConstantValue".equals(attributeName)) {
                int constantvalueIndex = readUnsignedShort(currentOffset3);
                constantValue = constantvalueIndex == 0 ? null : readConst(constantvalueIndex, charBuffer);
            } else if ("Signature".equals(attributeName)) {
                signature = readUTF8(currentOffset3, charBuffer);
            } else if ("Deprecated".equals(attributeName)) {
                accessFlags |= 131072;
            } else if ("Synthetic".equals(attributeName)) {
                accessFlags |= 4096;
            } else if ("RuntimeVisibleAnnotations".equals(attributeName)) {
                runtimeVisibleAnnotationsOffset = currentOffset3;
            } else if ("RuntimeVisibleTypeAnnotations".equals(attributeName)) {
                runtimeVisibleTypeAnnotationsOffset = currentOffset3;
            } else if ("RuntimeInvisibleAnnotations".equals(attributeName)) {
                runtimeInvisibleAnnotationsOffset = currentOffset3;
            } else if ("RuntimeInvisibleTypeAnnotations".equals(attributeName)) {
                runtimeInvisibleTypeAnnotationsOffset = currentOffset3;
            } else {
                Attribute attribute = readAttribute(context.attributePrototypes, attributeName, currentOffset3, attributeLength, charBuffer, -1, null);
                attribute.nextAttribute = attributes;
                attributes = attribute;
            }
            currentOffset2 = currentOffset3 + attributeLength;
        }
        FieldVisitor fieldVisitor = classVisitor.visitField(accessFlags, name, descriptor, signature, constantValue);
        if (fieldVisitor == null) {
            return currentOffset2;
        }
        if (runtimeVisibleAnnotationsOffset != 0) {
            int numAnnotations = readUnsignedShort(runtimeVisibleAnnotationsOffset);
            int elementValues = runtimeVisibleAnnotationsOffset + 2;
            while (true) {
                int currentAnnotationOffset = elementValues;
                int i2 = numAnnotations;
                numAnnotations--;
                if (i2 <= 0) {
                    break;
                }
                String annotationDescriptor = readUTF8(currentAnnotationOffset, charBuffer);
                elementValues = readElementValues(fieldVisitor.visitAnnotation(annotationDescriptor, true), currentAnnotationOffset + 2, true, charBuffer);
            }
        }
        if (runtimeInvisibleAnnotationsOffset != 0) {
            int numAnnotations2 = readUnsignedShort(runtimeInvisibleAnnotationsOffset);
            int elementValues2 = runtimeInvisibleAnnotationsOffset + 2;
            while (true) {
                int currentAnnotationOffset2 = elementValues2;
                int i3 = numAnnotations2;
                numAnnotations2--;
                if (i3 <= 0) {
                    break;
                }
                String annotationDescriptor2 = readUTF8(currentAnnotationOffset2, charBuffer);
                elementValues2 = readElementValues(fieldVisitor.visitAnnotation(annotationDescriptor2, false), currentAnnotationOffset2 + 2, true, charBuffer);
            }
        }
        if (runtimeVisibleTypeAnnotationsOffset != 0) {
            int numAnnotations3 = readUnsignedShort(runtimeVisibleTypeAnnotationsOffset);
            int elementValues3 = runtimeVisibleTypeAnnotationsOffset + 2;
            while (true) {
                int currentAnnotationOffset3 = elementValues3;
                int i4 = numAnnotations3;
                numAnnotations3--;
                if (i4 <= 0) {
                    break;
                }
                int currentAnnotationOffset4 = readTypeAnnotationTarget(context, currentAnnotationOffset3);
                String annotationDescriptor3 = readUTF8(currentAnnotationOffset4, charBuffer);
                elementValues3 = readElementValues(fieldVisitor.visitTypeAnnotation(context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath, annotationDescriptor3, true), currentAnnotationOffset4 + 2, true, charBuffer);
            }
        }
        if (runtimeInvisibleTypeAnnotationsOffset != 0) {
            int numAnnotations4 = readUnsignedShort(runtimeInvisibleTypeAnnotationsOffset);
            int elementValues4 = runtimeInvisibleTypeAnnotationsOffset + 2;
            while (true) {
                int currentAnnotationOffset5 = elementValues4;
                int i5 = numAnnotations4;
                numAnnotations4--;
                if (i5 <= 0) {
                    break;
                }
                int currentAnnotationOffset6 = readTypeAnnotationTarget(context, currentAnnotationOffset5);
                String annotationDescriptor4 = readUTF8(currentAnnotationOffset6, charBuffer);
                elementValues4 = readElementValues(fieldVisitor.visitTypeAnnotation(context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath, annotationDescriptor4, false), currentAnnotationOffset6 + 2, true, charBuffer);
            }
        }
        while (attributes != null) {
            Attribute nextAttribute = attributes.nextAttribute;
            attributes.nextAttribute = null;
            fieldVisitor.visitAttribute(attributes);
            attributes = nextAttribute;
        }
        fieldVisitor.visitEnd();
        return currentOffset2;
    }

    private int readMethod(ClassVisitor classVisitor, Context context, int methodInfoOffset) {
        char[] charBuffer = context.charBuffer;
        context.currentMethodAccessFlags = readUnsignedShort(methodInfoOffset);
        context.currentMethodName = readUTF8(methodInfoOffset + 2, charBuffer);
        context.currentMethodDescriptor = readUTF8(methodInfoOffset + 4, charBuffer);
        int currentOffset = methodInfoOffset + 6;
        int codeOffset = 0;
        int exceptionsOffset = 0;
        String[] exceptions = null;
        boolean synthetic = false;
        int signatureIndex = 0;
        int runtimeVisibleAnnotationsOffset = 0;
        int runtimeInvisibleAnnotationsOffset = 0;
        int runtimeVisibleParameterAnnotationsOffset = 0;
        int runtimeInvisibleParameterAnnotationsOffset = 0;
        int runtimeVisibleTypeAnnotationsOffset = 0;
        int runtimeInvisibleTypeAnnotationsOffset = 0;
        int annotationDefaultOffset = 0;
        int methodParametersOffset = 0;
        Attribute attributes = null;
        int attributesCount = readUnsignedShort(currentOffset);
        int currentOffset2 = currentOffset + 2;
        while (true) {
            int i = attributesCount;
            attributesCount--;
            if (i <= 0) {
                break;
            }
            String attributeName = readUTF8(currentOffset2, charBuffer);
            int attributeLength = readInt(currentOffset2 + 2);
            int currentOffset3 = currentOffset2 + 6;
            if ("Code".equals(attributeName)) {
                if ((context.parsingOptions & 1) == 0) {
                    codeOffset = currentOffset3;
                }
            } else if ("Exceptions".equals(attributeName)) {
                exceptionsOffset = currentOffset3;
                exceptions = new String[readUnsignedShort(exceptionsOffset)];
                int currentExceptionOffset = exceptionsOffset + 2;
                for (int i2 = 0; i2 < exceptions.length; i2++) {
                    exceptions[i2] = readClass(currentExceptionOffset, charBuffer);
                    currentExceptionOffset += 2;
                }
            } else if ("Signature".equals(attributeName)) {
                signatureIndex = readUnsignedShort(currentOffset3);
            } else if ("Deprecated".equals(attributeName)) {
                context.currentMethodAccessFlags |= 131072;
            } else if ("RuntimeVisibleAnnotations".equals(attributeName)) {
                runtimeVisibleAnnotationsOffset = currentOffset3;
            } else if ("RuntimeVisibleTypeAnnotations".equals(attributeName)) {
                runtimeVisibleTypeAnnotationsOffset = currentOffset3;
            } else if ("AnnotationDefault".equals(attributeName)) {
                annotationDefaultOffset = currentOffset3;
            } else if ("Synthetic".equals(attributeName)) {
                synthetic = true;
                context.currentMethodAccessFlags |= 4096;
            } else if ("RuntimeInvisibleAnnotations".equals(attributeName)) {
                runtimeInvisibleAnnotationsOffset = currentOffset3;
            } else if ("RuntimeInvisibleTypeAnnotations".equals(attributeName)) {
                runtimeInvisibleTypeAnnotationsOffset = currentOffset3;
            } else if ("RuntimeVisibleParameterAnnotations".equals(attributeName)) {
                runtimeVisibleParameterAnnotationsOffset = currentOffset3;
            } else if ("RuntimeInvisibleParameterAnnotations".equals(attributeName)) {
                runtimeInvisibleParameterAnnotationsOffset = currentOffset3;
            } else if ("MethodParameters".equals(attributeName)) {
                methodParametersOffset = currentOffset3;
            } else {
                Attribute attribute = readAttribute(context.attributePrototypes, attributeName, currentOffset3, attributeLength, charBuffer, -1, null);
                attribute.nextAttribute = attributes;
                attributes = attribute;
            }
            currentOffset2 = currentOffset3 + attributeLength;
        }
        MethodVisitor methodVisitor = classVisitor.visitMethod(context.currentMethodAccessFlags, context.currentMethodName, context.currentMethodDescriptor, signatureIndex == 0 ? null : readUtf(signatureIndex, charBuffer), exceptions);
        if (methodVisitor == null) {
            return currentOffset2;
        }
        if (methodVisitor instanceof MethodWriter) {
            MethodWriter methodWriter = (MethodWriter) methodVisitor;
            if (methodWriter.canCopyMethodAttributes(this, synthetic, (context.currentMethodAccessFlags & 131072) != 0, readUnsignedShort(methodInfoOffset + 4), signatureIndex, exceptionsOffset)) {
                methodWriter.setMethodAttributesSource(methodInfoOffset, currentOffset2 - methodInfoOffset);
                return currentOffset2;
            }
        }
        if (methodParametersOffset != 0 && (context.parsingOptions & 2) == 0) {
            int parametersCount = readByte(methodParametersOffset);
            int currentParameterOffset = methodParametersOffset + 1;
            while (true) {
                int i3 = parametersCount;
                parametersCount--;
                if (i3 <= 0) {
                    break;
                }
                methodVisitor.visitParameter(readUTF8(currentParameterOffset, charBuffer), readUnsignedShort(currentParameterOffset + 2));
                currentParameterOffset += 4;
            }
        }
        if (annotationDefaultOffset != 0) {
            AnnotationVisitor annotationVisitor = methodVisitor.visitAnnotationDefault();
            readElementValue(annotationVisitor, annotationDefaultOffset, null, charBuffer);
            if (annotationVisitor != null) {
                annotationVisitor.visitEnd();
            }
        }
        if (runtimeVisibleAnnotationsOffset != 0) {
            int numAnnotations = readUnsignedShort(runtimeVisibleAnnotationsOffset);
            int elementValues = runtimeVisibleAnnotationsOffset + 2;
            while (true) {
                int currentAnnotationOffset = elementValues;
                int i4 = numAnnotations;
                numAnnotations--;
                if (i4 <= 0) {
                    break;
                }
                String annotationDescriptor = readUTF8(currentAnnotationOffset, charBuffer);
                elementValues = readElementValues(methodVisitor.visitAnnotation(annotationDescriptor, true), currentAnnotationOffset + 2, true, charBuffer);
            }
        }
        if (runtimeInvisibleAnnotationsOffset != 0) {
            int numAnnotations2 = readUnsignedShort(runtimeInvisibleAnnotationsOffset);
            int elementValues2 = runtimeInvisibleAnnotationsOffset + 2;
            while (true) {
                int currentAnnotationOffset2 = elementValues2;
                int i5 = numAnnotations2;
                numAnnotations2--;
                if (i5 <= 0) {
                    break;
                }
                String annotationDescriptor2 = readUTF8(currentAnnotationOffset2, charBuffer);
                elementValues2 = readElementValues(methodVisitor.visitAnnotation(annotationDescriptor2, false), currentAnnotationOffset2 + 2, true, charBuffer);
            }
        }
        if (runtimeVisibleTypeAnnotationsOffset != 0) {
            int numAnnotations3 = readUnsignedShort(runtimeVisibleTypeAnnotationsOffset);
            int elementValues3 = runtimeVisibleTypeAnnotationsOffset + 2;
            while (true) {
                int currentAnnotationOffset3 = elementValues3;
                int i6 = numAnnotations3;
                numAnnotations3--;
                if (i6 <= 0) {
                    break;
                }
                int currentAnnotationOffset4 = readTypeAnnotationTarget(context, currentAnnotationOffset3);
                String annotationDescriptor3 = readUTF8(currentAnnotationOffset4, charBuffer);
                elementValues3 = readElementValues(methodVisitor.visitTypeAnnotation(context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath, annotationDescriptor3, true), currentAnnotationOffset4 + 2, true, charBuffer);
            }
        }
        if (runtimeInvisibleTypeAnnotationsOffset != 0) {
            int numAnnotations4 = readUnsignedShort(runtimeInvisibleTypeAnnotationsOffset);
            int elementValues4 = runtimeInvisibleTypeAnnotationsOffset + 2;
            while (true) {
                int currentAnnotationOffset5 = elementValues4;
                int i7 = numAnnotations4;
                numAnnotations4--;
                if (i7 <= 0) {
                    break;
                }
                int currentAnnotationOffset6 = readTypeAnnotationTarget(context, currentAnnotationOffset5);
                String annotationDescriptor4 = readUTF8(currentAnnotationOffset6, charBuffer);
                elementValues4 = readElementValues(methodVisitor.visitTypeAnnotation(context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath, annotationDescriptor4, false), currentAnnotationOffset6 + 2, true, charBuffer);
            }
        }
        if (runtimeVisibleParameterAnnotationsOffset != 0) {
            readParameterAnnotations(methodVisitor, context, runtimeVisibleParameterAnnotationsOffset, true);
        }
        if (runtimeInvisibleParameterAnnotationsOffset != 0) {
            readParameterAnnotations(methodVisitor, context, runtimeInvisibleParameterAnnotationsOffset, false);
        }
        while (attributes != null) {
            Attribute nextAttribute = attributes.nextAttribute;
            attributes.nextAttribute = null;
            methodVisitor.visitAttribute(attributes);
            attributes = nextAttribute;
        }
        if (codeOffset != 0) {
            methodVisitor.visitCode();
            readCode(methodVisitor, context, codeOffset);
        }
        methodVisitor.visitEnd();
        return currentOffset2;
    }

    private void readCode(MethodVisitor methodVisitor, Context context, int codeOffset) {
        int potentialBytecodeOffset;
        byte[] classBuffer = this.classFileBuffer;
        char[] charBuffer = context.charBuffer;
        int maxStack = readUnsignedShort(codeOffset);
        int maxLocals = readUnsignedShort(codeOffset + 2);
        int codeLength = readInt(codeOffset + 4);
        int currentOffset = codeOffset + 8;
        int bytecodeEndOffset = currentOffset + codeLength;
        Label[] labels = new Label[codeLength + 1];
        context.currentMethodLabels = labels;
        while (currentOffset < bytecodeEndOffset) {
            int bytecodeOffset = currentOffset - currentOffset;
            switch (classBuffer[currentOffset] & 255) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 72:
                case 73:
                case 74:
                case 75:
                case 76:
                case 77:
                case 78:
                case 79:
                case 80:
                case 81:
                case 82:
                case 83:
                case 84:
                case 85:
                case 86:
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                case 96:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                case 107:
                case 108:
                case 109:
                case 110:
                case 111:
                case 112:
                case 113:
                case 114:
                case 115:
                case 116:
                case 117:
                case 118:
                case 119:
                case 120:
                case 121:
                case 122:
                case 123:
                case 124:
                case Opcodes.LUSHR /* 125 */:
                case 126:
                case Opcodes.LAND /* 127 */:
                case 128:
                case Opcodes.LOR /* 129 */:
                case 130:
                case Opcodes.LXOR /* 131 */:
                case Opcodes.I2L /* 133 */:
                case Opcodes.I2F /* 134 */:
                case Opcodes.I2D /* 135 */:
                case Opcodes.L2I /* 136 */:
                case Opcodes.L2F /* 137 */:
                case Opcodes.L2D /* 138 */:
                case Opcodes.F2I /* 139 */:
                case Opcodes.F2L /* 140 */:
                case Opcodes.F2D /* 141 */:
                case Opcodes.D2I /* 142 */:
                case Opcodes.D2L /* 143 */:
                case Opcodes.D2F /* 144 */:
                case Opcodes.I2B /* 145 */:
                case Opcodes.I2C /* 146 */:
                case Opcodes.I2S /* 147 */:
                case Opcodes.LCMP /* 148 */:
                case Opcodes.FCMPL /* 149 */:
                case 150:
                case Opcodes.DCMPL /* 151 */:
                case Opcodes.DCMPG /* 152 */:
                case Opcodes.IRETURN /* 172 */:
                case Opcodes.LRETURN /* 173 */:
                case Opcodes.FRETURN /* 174 */:
                case 175:
                case Opcodes.ARETURN /* 176 */:
                case Opcodes.RETURN /* 177 */:
                case Opcodes.ARRAYLENGTH /* 190 */:
                case Opcodes.ATHROW /* 191 */:
                case Opcodes.MONITORENTER /* 194 */:
                case Opcodes.MONITOREXIT /* 195 */:
                    currentOffset++;
                    break;
                case 16:
                case 18:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case Opcodes.RET /* 169 */:
                case Opcodes.NEWARRAY /* 188 */:
                    currentOffset += 2;
                    break;
                case 17:
                case 19:
                case 20:
                case Opcodes.IINC /* 132 */:
                case Opcodes.GETSTATIC /* 178 */:
                case Opcodes.PUTSTATIC /* 179 */:
                case 180:
                case Opcodes.PUTFIELD /* 181 */:
                case Opcodes.INVOKEVIRTUAL /* 182 */:
                case Opcodes.INVOKESPECIAL /* 183 */:
                case Opcodes.INVOKESTATIC /* 184 */:
                case Opcodes.NEW /* 187 */:
                case Opcodes.ANEWARRAY /* 189 */:
                case Opcodes.CHECKCAST /* 192 */:
                case Opcodes.INSTANCEOF /* 193 */:
                    currentOffset += 3;
                    break;
                case 153:
                case 154:
                case 155:
                case 156:
                case 157:
                case 158:
                case Opcodes.IF_ICMPEQ /* 159 */:
                case Opcodes.IF_ICMPNE /* 160 */:
                case Opcodes.IF_ICMPLT /* 161 */:
                case Opcodes.IF_ICMPGE /* 162 */:
                case Opcodes.IF_ICMPGT /* 163 */:
                case Opcodes.IF_ICMPLE /* 164 */:
                case Opcodes.IF_ACMPEQ /* 165 */:
                case Opcodes.IF_ACMPNE /* 166 */:
                case Opcodes.GOTO /* 167 */:
                case Opcodes.JSR /* 168 */:
                case Opcodes.IFNULL /* 198 */:
                case Opcodes.IFNONNULL /* 199 */:
                    createLabel(bytecodeOffset + readShort(currentOffset + 1), labels);
                    currentOffset += 3;
                    break;
                case Opcodes.TABLESWITCH /* 170 */:
                    int currentOffset2 = currentOffset + (4 - (bytecodeOffset & 3));
                    createLabel(bytecodeOffset + readInt(currentOffset2), labels);
                    int numTableEntries = (readInt(currentOffset2 + 8) - readInt(currentOffset2 + 4)) + 1;
                    currentOffset = currentOffset2 + 12;
                    while (true) {
                        int i = numTableEntries;
                        numTableEntries--;
                        if (i > 0) {
                            createLabel(bytecodeOffset + readInt(currentOffset), labels);
                            currentOffset += 4;
                        }
                    }
                    break;
                case Opcodes.LOOKUPSWITCH /* 171 */:
                    currentOffset += 4 - (bytecodeOffset & 3);
                    createLabel(bytecodeOffset + readInt(currentOffset), labels);
                    int numSwitchCases = readInt(currentOffset + 4);
                    while (true) {
                        currentOffset += 8;
                        int i2 = numSwitchCases;
                        numSwitchCases--;
                        if (i2 > 0) {
                            createLabel(bytecodeOffset + readInt(currentOffset + 4), labels);
                        }
                    }
                    break;
                case Opcodes.INVOKEINTERFACE /* 185 */:
                case Opcodes.INVOKEDYNAMIC /* 186 */:
                    currentOffset += 5;
                    break;
                case 196:
                    switch (classBuffer[currentOffset + 1] & 255) {
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                        case 58:
                        case Opcodes.RET /* 169 */:
                            currentOffset += 4;
                            break;
                        case Opcodes.IINC /* 132 */:
                            currentOffset += 6;
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
                    break;
                case Opcodes.MULTIANEWARRAY /* 197 */:
                    currentOffset += 4;
                    break;
                case 200:
                case 201:
                case 220:
                    createLabel(bytecodeOffset + readInt(currentOffset + 1), labels);
                    currentOffset += 5;
                    break;
                case 202:
                case 203:
                case 204:
                case 205:
                case 206:
                case 207:
                case 208:
                case 209:
                case 210:
                case 211:
                case 212:
                case 213:
                case 214:
                case 215:
                case 216:
                case 217:
                case 218:
                case 219:
                    createLabel(bytecodeOffset + readUnsignedShort(currentOffset + 1), labels);
                    currentOffset += 3;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        int exceptionTableLength = readUnsignedShort(currentOffset);
        int currentOffset3 = currentOffset + 2;
        while (true) {
            int i3 = exceptionTableLength;
            exceptionTableLength--;
            if (i3 > 0) {
                Label start = createLabel(readUnsignedShort(currentOffset3), labels);
                Label end = createLabel(readUnsignedShort(currentOffset3 + 2), labels);
                Label handler = createLabel(readUnsignedShort(currentOffset3 + 4), labels);
                String catchType = readUTF8(this.cpInfoOffsets[readUnsignedShort(currentOffset3 + 6)], charBuffer);
                currentOffset3 += 8;
                methodVisitor.visitTryCatchBlock(start, end, handler, catchType);
            } else {
                int stackMapFrameOffset = 0;
                int stackMapTableEndOffset = 0;
                boolean compressedFrames = true;
                int localVariableTableOffset = 0;
                int localVariableTypeTableOffset = 0;
                int[] visibleTypeAnnotationOffsets = null;
                int[] invisibleTypeAnnotationOffsets = null;
                Attribute attributes = null;
                int attributesCount = readUnsignedShort(currentOffset3);
                int currentOffset4 = currentOffset3 + 2;
                while (true) {
                    int i4 = attributesCount;
                    attributesCount--;
                    if (i4 > 0) {
                        String attributeName = readUTF8(currentOffset4, charBuffer);
                        int attributeLength = readInt(currentOffset4 + 2);
                        int currentOffset5 = currentOffset4 + 6;
                        if ("LocalVariableTable".equals(attributeName)) {
                            if ((context.parsingOptions & 2) == 0) {
                                localVariableTableOffset = currentOffset5;
                                int localVariableTableLength = readUnsignedShort(currentOffset5);
                                int currentLocalVariableTableOffset = currentOffset5 + 2;
                                while (true) {
                                    int i5 = localVariableTableLength;
                                    localVariableTableLength--;
                                    if (i5 > 0) {
                                        int startPc = readUnsignedShort(currentLocalVariableTableOffset);
                                        createDebugLabel(startPc, labels);
                                        int length = readUnsignedShort(currentLocalVariableTableOffset + 2);
                                        createDebugLabel(startPc + length, labels);
                                        currentLocalVariableTableOffset += 10;
                                    }
                                }
                            }
                        } else if ("LocalVariableTypeTable".equals(attributeName)) {
                            localVariableTypeTableOffset = currentOffset5;
                        } else if ("LineNumberTable".equals(attributeName)) {
                            if ((context.parsingOptions & 2) == 0) {
                                int lineNumberTableLength = readUnsignedShort(currentOffset5);
                                int currentLineNumberTableOffset = currentOffset5 + 2;
                                while (true) {
                                    int i6 = lineNumberTableLength;
                                    lineNumberTableLength--;
                                    if (i6 > 0) {
                                        int startPc2 = readUnsignedShort(currentLineNumberTableOffset);
                                        int lineNumber = readUnsignedShort(currentLineNumberTableOffset + 2);
                                        currentLineNumberTableOffset += 4;
                                        createDebugLabel(startPc2, labels);
                                        labels[startPc2].addLineNumber(lineNumber);
                                    }
                                }
                            }
                        } else if ("RuntimeVisibleTypeAnnotations".equals(attributeName)) {
                            visibleTypeAnnotationOffsets = readTypeAnnotations(methodVisitor, context, currentOffset5, true);
                        } else if ("RuntimeInvisibleTypeAnnotations".equals(attributeName)) {
                            invisibleTypeAnnotationOffsets = readTypeAnnotations(methodVisitor, context, currentOffset5, false);
                        } else if ("StackMapTable".equals(attributeName)) {
                            if ((context.parsingOptions & 4) == 0) {
                                stackMapFrameOffset = currentOffset5 + 2;
                                stackMapTableEndOffset = currentOffset5 + attributeLength;
                            }
                        } else if ("StackMap".equals(attributeName)) {
                            if ((context.parsingOptions & 4) == 0) {
                                stackMapFrameOffset = currentOffset5 + 2;
                                stackMapTableEndOffset = currentOffset5 + attributeLength;
                                compressedFrames = false;
                            }
                        } else {
                            Attribute attribute = readAttribute(context.attributePrototypes, attributeName, currentOffset5, attributeLength, charBuffer, codeOffset, labels);
                            attribute.nextAttribute = attributes;
                            attributes = attribute;
                        }
                        currentOffset4 = currentOffset5 + attributeLength;
                    } else {
                        boolean expandFrames = (context.parsingOptions & 8) != 0;
                        if (stackMapFrameOffset != 0) {
                            context.currentFrameOffset = -1;
                            context.currentFrameType = 0;
                            context.currentFrameLocalCount = 0;
                            context.currentFrameLocalCountDelta = 0;
                            context.currentFrameLocalTypes = new Object[maxLocals];
                            context.currentFrameStackCount = 0;
                            context.currentFrameStackTypes = new Object[maxStack];
                            if (expandFrames) {
                                computeImplicitFrame(context);
                            }
                            for (int offset = stackMapFrameOffset; offset < stackMapTableEndOffset - 2; offset++) {
                                if (classBuffer[offset] == 8 && (potentialBytecodeOffset = readUnsignedShort(offset + 1)) >= 0 && potentialBytecodeOffset < codeLength && (classBuffer[currentOffset + potentialBytecodeOffset] & 255) == 187) {
                                    createLabel(potentialBytecodeOffset, labels);
                                }
                            }
                        }
                        if (expandFrames && (context.parsingOptions & 256) != 0) {
                            methodVisitor.visitFrame(-1, maxLocals, null, 0, null);
                        }
                        int currentVisibleTypeAnnotationIndex = 0;
                        int currentVisibleTypeAnnotationBytecodeOffset = getTypeAnnotationBytecodeOffset(visibleTypeAnnotationOffsets, 0);
                        int currentInvisibleTypeAnnotationIndex = 0;
                        int currentInvisibleTypeAnnotationBytecodeOffset = getTypeAnnotationBytecodeOffset(invisibleTypeAnnotationOffsets, 0);
                        boolean insertFrame = false;
                        int wideJumpOpcodeDelta = (context.parsingOptions & 256) == 0 ? 33 : 0;
                        int currentOffset6 = currentOffset;
                        while (currentOffset6 < bytecodeEndOffset) {
                            int currentBytecodeOffset = currentOffset6 - currentOffset;
                            Label currentLabel = labels[currentBytecodeOffset];
                            if (currentLabel != null) {
                                currentLabel.accept(methodVisitor, (context.parsingOptions & 2) == 0);
                            }
                            while (stackMapFrameOffset != 0 && (context.currentFrameOffset == currentBytecodeOffset || context.currentFrameOffset == -1)) {
                                if (context.currentFrameOffset != -1) {
                                    if (!compressedFrames || expandFrames) {
                                        methodVisitor.visitFrame(-1, context.currentFrameLocalCount, context.currentFrameLocalTypes, context.currentFrameStackCount, context.currentFrameStackTypes);
                                    } else {
                                        methodVisitor.visitFrame(context.currentFrameType, context.currentFrameLocalCountDelta, context.currentFrameLocalTypes, context.currentFrameStackCount, context.currentFrameStackTypes);
                                    }
                                    insertFrame = false;
                                }
                                if (stackMapFrameOffset < stackMapTableEndOffset) {
                                    stackMapFrameOffset = readStackMapFrame(stackMapFrameOffset, compressedFrames, expandFrames, context);
                                } else {
                                    stackMapFrameOffset = 0;
                                }
                            }
                            if (insertFrame) {
                                if ((context.parsingOptions & 8) != 0) {
                                    methodVisitor.visitFrame(256, 0, null, 0, null);
                                }
                                insertFrame = false;
                            }
                            int opcode = classBuffer[currentOffset6] & 255;
                            switch (opcode) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 46:
                                case 47:
                                case 48:
                                case 49:
                                case 50:
                                case 51:
                                case 52:
                                case 53:
                                case 79:
                                case 80:
                                case 81:
                                case 82:
                                case 83:
                                case 84:
                                case 85:
                                case 86:
                                case 87:
                                case 88:
                                case 89:
                                case 90:
                                case 91:
                                case 92:
                                case 93:
                                case 94:
                                case 95:
                                case 96:
                                case 97:
                                case 98:
                                case 99:
                                case 100:
                                case 101:
                                case 102:
                                case 103:
                                case 104:
                                case 105:
                                case 106:
                                case 107:
                                case 108:
                                case 109:
                                case 110:
                                case 111:
                                case 112:
                                case 113:
                                case 114:
                                case 115:
                                case 116:
                                case 117:
                                case 118:
                                case 119:
                                case 120:
                                case 121:
                                case 122:
                                case 123:
                                case 124:
                                case Opcodes.LUSHR /* 125 */:
                                case 126:
                                case Opcodes.LAND /* 127 */:
                                case 128:
                                case Opcodes.LOR /* 129 */:
                                case 130:
                                case Opcodes.LXOR /* 131 */:
                                case Opcodes.I2L /* 133 */:
                                case Opcodes.I2F /* 134 */:
                                case Opcodes.I2D /* 135 */:
                                case Opcodes.L2I /* 136 */:
                                case Opcodes.L2F /* 137 */:
                                case Opcodes.L2D /* 138 */:
                                case Opcodes.F2I /* 139 */:
                                case Opcodes.F2L /* 140 */:
                                case Opcodes.F2D /* 141 */:
                                case Opcodes.D2I /* 142 */:
                                case Opcodes.D2L /* 143 */:
                                case Opcodes.D2F /* 144 */:
                                case Opcodes.I2B /* 145 */:
                                case Opcodes.I2C /* 146 */:
                                case Opcodes.I2S /* 147 */:
                                case Opcodes.LCMP /* 148 */:
                                case Opcodes.FCMPL /* 149 */:
                                case 150:
                                case Opcodes.DCMPL /* 151 */:
                                case Opcodes.DCMPG /* 152 */:
                                case Opcodes.IRETURN /* 172 */:
                                case Opcodes.LRETURN /* 173 */:
                                case Opcodes.FRETURN /* 174 */:
                                case 175:
                                case Opcodes.ARETURN /* 176 */:
                                case Opcodes.RETURN /* 177 */:
                                case Opcodes.ARRAYLENGTH /* 190 */:
                                case Opcodes.ATHROW /* 191 */:
                                case Opcodes.MONITORENTER /* 194 */:
                                case Opcodes.MONITOREXIT /* 195 */:
                                    methodVisitor.visitInsn(opcode);
                                    currentOffset6++;
                                    break;
                                case 16:
                                case Opcodes.NEWARRAY /* 188 */:
                                    methodVisitor.visitIntInsn(opcode, classBuffer[currentOffset6 + 1]);
                                    currentOffset6 += 2;
                                    break;
                                case 17:
                                    methodVisitor.visitIntInsn(opcode, readShort(currentOffset6 + 1));
                                    currentOffset6 += 3;
                                    break;
                                case 18:
                                    methodVisitor.visitLdcInsn(readConst(classBuffer[currentOffset6 + 1] & 255, charBuffer));
                                    currentOffset6 += 2;
                                    break;
                                case 19:
                                case 20:
                                    methodVisitor.visitLdcInsn(readConst(readUnsignedShort(currentOffset6 + 1), charBuffer));
                                    currentOffset6 += 3;
                                    break;
                                case 21:
                                case 22:
                                case 23:
                                case 24:
                                case 25:
                                case 54:
                                case 55:
                                case 56:
                                case 57:
                                case 58:
                                case Opcodes.RET /* 169 */:
                                    methodVisitor.visitVarInsn(opcode, classBuffer[currentOffset6 + 1] & 255);
                                    currentOffset6 += 2;
                                    break;
                                case 26:
                                case 27:
                                case 28:
                                case 29:
                                case 30:
                                case 31:
                                case 32:
                                case 33:
                                case 34:
                                case 35:
                                case 36:
                                case 37:
                                case 38:
                                case 39:
                                case 40:
                                case 41:
                                case 42:
                                case 43:
                                case 44:
                                case 45:
                                    int opcode2 = opcode - 26;
                                    methodVisitor.visitVarInsn(21 + (opcode2 >> 2), opcode2 & 3);
                                    currentOffset6++;
                                    break;
                                case 59:
                                case 60:
                                case 61:
                                case 62:
                                case 63:
                                case 64:
                                case 65:
                                case 66:
                                case 67:
                                case 68:
                                case 69:
                                case 70:
                                case 71:
                                case 72:
                                case 73:
                                case 74:
                                case 75:
                                case 76:
                                case 77:
                                case 78:
                                    int opcode3 = opcode - 59;
                                    methodVisitor.visitVarInsn(54 + (opcode3 >> 2), opcode3 & 3);
                                    currentOffset6++;
                                    break;
                                case Opcodes.IINC /* 132 */:
                                    methodVisitor.visitIincInsn(classBuffer[currentOffset6 + 1] & 255, classBuffer[currentOffset6 + 2]);
                                    currentOffset6 += 3;
                                    break;
                                case 153:
                                case 154:
                                case 155:
                                case 156:
                                case 157:
                                case 158:
                                case Opcodes.IF_ICMPEQ /* 159 */:
                                case Opcodes.IF_ICMPNE /* 160 */:
                                case Opcodes.IF_ICMPLT /* 161 */:
                                case Opcodes.IF_ICMPGE /* 162 */:
                                case Opcodes.IF_ICMPGT /* 163 */:
                                case Opcodes.IF_ICMPLE /* 164 */:
                                case Opcodes.IF_ACMPEQ /* 165 */:
                                case Opcodes.IF_ACMPNE /* 166 */:
                                case Opcodes.GOTO /* 167 */:
                                case Opcodes.JSR /* 168 */:
                                case Opcodes.IFNULL /* 198 */:
                                case Opcodes.IFNONNULL /* 199 */:
                                    methodVisitor.visitJumpInsn(opcode, labels[currentBytecodeOffset + readShort(currentOffset6 + 1)]);
                                    currentOffset6 += 3;
                                    break;
                                case Opcodes.TABLESWITCH /* 170 */:
                                    int currentOffset7 = currentOffset6 + (4 - (currentBytecodeOffset & 3));
                                    Label defaultLabel = labels[currentBytecodeOffset + readInt(currentOffset7)];
                                    int low = readInt(currentOffset7 + 4);
                                    int high = readInt(currentOffset7 + 8);
                                    currentOffset6 = currentOffset7 + 12;
                                    Label[] table = new Label[(high - low) + 1];
                                    for (int i7 = 0; i7 < table.length; i7++) {
                                        table[i7] = labels[currentBytecodeOffset + readInt(currentOffset6)];
                                        currentOffset6 += 4;
                                    }
                                    methodVisitor.visitTableSwitchInsn(low, high, defaultLabel, table);
                                    break;
                                case Opcodes.LOOKUPSWITCH /* 171 */:
                                    int currentOffset8 = currentOffset6 + (4 - (currentBytecodeOffset & 3));
                                    Label defaultLabel2 = labels[currentBytecodeOffset + readInt(currentOffset8)];
                                    int numPairs = readInt(currentOffset8 + 4);
                                    currentOffset6 = currentOffset8 + 8;
                                    int[] keys = new int[numPairs];
                                    Label[] values = new Label[numPairs];
                                    for (int i8 = 0; i8 < numPairs; i8++) {
                                        keys[i8] = readInt(currentOffset6);
                                        values[i8] = labels[currentBytecodeOffset + readInt(currentOffset6 + 4)];
                                        currentOffset6 += 8;
                                    }
                                    methodVisitor.visitLookupSwitchInsn(defaultLabel2, keys, values);
                                    break;
                                case Opcodes.GETSTATIC /* 178 */:
                                case Opcodes.PUTSTATIC /* 179 */:
                                case 180:
                                case Opcodes.PUTFIELD /* 181 */:
                                case Opcodes.INVOKEVIRTUAL /* 182 */:
                                case Opcodes.INVOKESPECIAL /* 183 */:
                                case Opcodes.INVOKESTATIC /* 184 */:
                                case Opcodes.INVOKEINTERFACE /* 185 */:
                                    int cpInfoOffset = this.cpInfoOffsets[readUnsignedShort(currentOffset6 + 1)];
                                    int nameAndTypeCpInfoOffset = this.cpInfoOffsets[readUnsignedShort(cpInfoOffset + 2)];
                                    String owner = readClass(cpInfoOffset, charBuffer);
                                    String name = readUTF8(nameAndTypeCpInfoOffset, charBuffer);
                                    String descriptor = readUTF8(nameAndTypeCpInfoOffset + 2, charBuffer);
                                    if (opcode < 182) {
                                        methodVisitor.visitFieldInsn(opcode, owner, name, descriptor);
                                    } else {
                                        boolean isInterface = classBuffer[cpInfoOffset - 1] == 11;
                                        methodVisitor.visitMethodInsn(opcode, owner, name, descriptor, isInterface);
                                    }
                                    if (opcode == 185) {
                                        currentOffset6 += 5;
                                    } else {
                                        currentOffset6 += 3;
                                    }
                                    break;
                                case Opcodes.INVOKEDYNAMIC /* 186 */:
                                    int cpInfoOffset2 = this.cpInfoOffsets[readUnsignedShort(currentOffset6 + 1)];
                                    int nameAndTypeCpInfoOffset2 = this.cpInfoOffsets[readUnsignedShort(cpInfoOffset2 + 2)];
                                    String name2 = readUTF8(nameAndTypeCpInfoOffset2, charBuffer);
                                    String descriptor2 = readUTF8(nameAndTypeCpInfoOffset2 + 2, charBuffer);
                                    int bootstrapMethodOffset = this.bootstrapMethodOffsets[readUnsignedShort(cpInfoOffset2)];
                                    Handle handle = (Handle) readConst(readUnsignedShort(bootstrapMethodOffset), charBuffer);
                                    Object[] bootstrapMethodArguments = new Object[readUnsignedShort(bootstrapMethodOffset + 2)];
                                    int bootstrapMethodOffset2 = bootstrapMethodOffset + 4;
                                    for (int i9 = 0; i9 < bootstrapMethodArguments.length; i9++) {
                                        bootstrapMethodArguments[i9] = readConst(readUnsignedShort(bootstrapMethodOffset2), charBuffer);
                                        bootstrapMethodOffset2 += 2;
                                    }
                                    methodVisitor.visitInvokeDynamicInsn(name2, descriptor2, handle, bootstrapMethodArguments);
                                    currentOffset6 += 5;
                                    break;
                                case Opcodes.NEW /* 187 */:
                                case Opcodes.ANEWARRAY /* 189 */:
                                case Opcodes.CHECKCAST /* 192 */:
                                case Opcodes.INSTANCEOF /* 193 */:
                                    methodVisitor.visitTypeInsn(opcode, readClass(currentOffset6 + 1, charBuffer));
                                    currentOffset6 += 3;
                                    break;
                                case 196:
                                    int opcode4 = classBuffer[currentOffset6 + 1] & 255;
                                    if (opcode4 == 132) {
                                        methodVisitor.visitIincInsn(readUnsignedShort(currentOffset6 + 2), readShort(currentOffset6 + 4));
                                        currentOffset6 += 6;
                                    } else {
                                        methodVisitor.visitVarInsn(opcode4, readUnsignedShort(currentOffset6 + 2));
                                        currentOffset6 += 4;
                                    }
                                    break;
                                case Opcodes.MULTIANEWARRAY /* 197 */:
                                    methodVisitor.visitMultiANewArrayInsn(readClass(currentOffset6 + 1, charBuffer), classBuffer[currentOffset6 + 3] & 255);
                                    currentOffset6 += 4;
                                    break;
                                case 200:
                                case 201:
                                    methodVisitor.visitJumpInsn(opcode - wideJumpOpcodeDelta, labels[currentBytecodeOffset + readInt(currentOffset6 + 1)]);
                                    currentOffset6 += 5;
                                    break;
                                case 202:
                                case 203:
                                case 204:
                                case 205:
                                case 206:
                                case 207:
                                case 208:
                                case 209:
                                case 210:
                                case 211:
                                case 212:
                                case 213:
                                case 214:
                                case 215:
                                case 216:
                                case 217:
                                case 218:
                                case 219:
                                    int opcode5 = opcode < 218 ? opcode - 49 : opcode - 20;
                                    Label target = labels[currentBytecodeOffset + readUnsignedShort(currentOffset6 + 1)];
                                    if (opcode5 == 167 || opcode5 == 168) {
                                        methodVisitor.visitJumpInsn(opcode5 + 33, target);
                                    } else {
                                        int opcode6 = opcode5 < 167 ? ((opcode5 + 1) ^ 1) - 1 : opcode5 ^ 1;
                                        Label endif = createLabel(currentBytecodeOffset + 3, labels);
                                        methodVisitor.visitJumpInsn(opcode6, endif);
                                        methodVisitor.visitJumpInsn(200, target);
                                        insertFrame = true;
                                    }
                                    currentOffset6 += 3;
                                    break;
                                case 220:
                                    methodVisitor.visitJumpInsn(200, labels[currentBytecodeOffset + readInt(currentOffset6 + 1)]);
                                    insertFrame = true;
                                    currentOffset6 += 5;
                                    break;
                                default:
                                    throw new AssertionError();
                            }
                            while (visibleTypeAnnotationOffsets != null && currentVisibleTypeAnnotationIndex < visibleTypeAnnotationOffsets.length && currentVisibleTypeAnnotationBytecodeOffset <= currentBytecodeOffset) {
                                if (currentVisibleTypeAnnotationBytecodeOffset == currentBytecodeOffset) {
                                    int currentAnnotationOffset = readTypeAnnotationTarget(context, visibleTypeAnnotationOffsets[currentVisibleTypeAnnotationIndex]);
                                    String annotationDescriptor = readUTF8(currentAnnotationOffset, charBuffer);
                                    readElementValues(methodVisitor.visitInsnAnnotation(context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath, annotationDescriptor, true), currentAnnotationOffset + 2, true, charBuffer);
                                }
                                currentVisibleTypeAnnotationIndex++;
                                currentVisibleTypeAnnotationBytecodeOffset = getTypeAnnotationBytecodeOffset(visibleTypeAnnotationOffsets, currentVisibleTypeAnnotationIndex);
                            }
                            while (invisibleTypeAnnotationOffsets != null && currentInvisibleTypeAnnotationIndex < invisibleTypeAnnotationOffsets.length && currentInvisibleTypeAnnotationBytecodeOffset <= currentBytecodeOffset) {
                                if (currentInvisibleTypeAnnotationBytecodeOffset == currentBytecodeOffset) {
                                    int currentAnnotationOffset2 = readTypeAnnotationTarget(context, invisibleTypeAnnotationOffsets[currentInvisibleTypeAnnotationIndex]);
                                    String annotationDescriptor2 = readUTF8(currentAnnotationOffset2, charBuffer);
                                    readElementValues(methodVisitor.visitInsnAnnotation(context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath, annotationDescriptor2, false), currentAnnotationOffset2 + 2, true, charBuffer);
                                }
                                currentInvisibleTypeAnnotationIndex++;
                                currentInvisibleTypeAnnotationBytecodeOffset = getTypeAnnotationBytecodeOffset(invisibleTypeAnnotationOffsets, currentInvisibleTypeAnnotationIndex);
                            }
                        }
                        if (labels[codeLength] != null) {
                            methodVisitor.visitLabel(labels[codeLength]);
                        }
                        if (localVariableTableOffset != 0 && (context.parsingOptions & 2) == 0) {
                            int[] typeTable = null;
                            if (localVariableTypeTableOffset != 0) {
                                typeTable = new int[readUnsignedShort(localVariableTypeTableOffset) * 3];
                                int currentOffset9 = localVariableTypeTableOffset + 2;
                                int typeTableIndex = typeTable.length;
                                while (typeTableIndex > 0) {
                                    int typeTableIndex2 = typeTableIndex - 1;
                                    typeTable[typeTableIndex2] = currentOffset9 + 6;
                                    int typeTableIndex3 = typeTableIndex2 - 1;
                                    typeTable[typeTableIndex3] = readUnsignedShort(currentOffset9 + 8);
                                    typeTableIndex = typeTableIndex3 - 1;
                                    typeTable[typeTableIndex] = readUnsignedShort(currentOffset9);
                                    currentOffset9 += 10;
                                }
                            }
                            int localVariableTableLength2 = readUnsignedShort(localVariableTableOffset);
                            int currentOffset10 = localVariableTableOffset + 2;
                            while (true) {
                                int i10 = localVariableTableLength2;
                                localVariableTableLength2--;
                                if (i10 > 0) {
                                    int startPc3 = readUnsignedShort(currentOffset10);
                                    int length2 = readUnsignedShort(currentOffset10 + 2);
                                    String name3 = readUTF8(currentOffset10 + 4, charBuffer);
                                    String descriptor3 = readUTF8(currentOffset10 + 6, charBuffer);
                                    int index = readUnsignedShort(currentOffset10 + 8);
                                    currentOffset10 += 10;
                                    String signature = null;
                                    if (typeTable != null) {
                                        for (int i11 = 0; i11 < typeTable.length; i11 += 3) {
                                            if (typeTable[i11] == startPc3 && typeTable[i11 + 1] == index) {
                                                signature = readUTF8(typeTable[i11 + 2], charBuffer);
                                                break;
                                            }
                                        }
                                    }
                                    methodVisitor.visitLocalVariable(name3, descriptor3, signature, labels[startPc3], labels[startPc3 + length2], index);
                                }
                            }
                        }
                        if (visibleTypeAnnotationOffsets != null) {
                            for (int typeAnnotationOffset : visibleTypeAnnotationOffsets) {
                                int targetType = readByte(typeAnnotationOffset);
                                if (targetType == 64 || targetType == 65) {
                                    int currentOffset11 = readTypeAnnotationTarget(context, typeAnnotationOffset);
                                    String annotationDescriptor3 = readUTF8(currentOffset11, charBuffer);
                                    readElementValues(methodVisitor.visitLocalVariableAnnotation(context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath, context.currentLocalVariableAnnotationRangeStarts, context.currentLocalVariableAnnotationRangeEnds, context.currentLocalVariableAnnotationRangeIndices, annotationDescriptor3, true), currentOffset11 + 2, true, charBuffer);
                                }
                            }
                        }
                        if (invisibleTypeAnnotationOffsets != null) {
                            for (int typeAnnotationOffset2 : invisibleTypeAnnotationOffsets) {
                                int targetType2 = readByte(typeAnnotationOffset2);
                                if (targetType2 == 64 || targetType2 == 65) {
                                    int currentOffset12 = readTypeAnnotationTarget(context, typeAnnotationOffset2);
                                    String annotationDescriptor4 = readUTF8(currentOffset12, charBuffer);
                                    readElementValues(methodVisitor.visitLocalVariableAnnotation(context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath, context.currentLocalVariableAnnotationRangeStarts, context.currentLocalVariableAnnotationRangeEnds, context.currentLocalVariableAnnotationRangeIndices, annotationDescriptor4, false), currentOffset12 + 2, true, charBuffer);
                                }
                            }
                        }
                        while (attributes != null) {
                            Attribute nextAttribute = attributes.nextAttribute;
                            attributes.nextAttribute = null;
                            methodVisitor.visitAttribute(attributes);
                            attributes = nextAttribute;
                        }
                        methodVisitor.visitMaxs(maxStack, maxLocals);
                        return;
                    }
                }
            }
        }
    }

    protected Label readLabel(int bytecodeOffset, Label[] labels) {
        if (labels[bytecodeOffset] == null) {
            labels[bytecodeOffset] = new Label();
        }
        return labels[bytecodeOffset];
    }

    private Label createLabel(int bytecodeOffset, Label[] labels) {
        Label label = readLabel(bytecodeOffset, labels);
        label.flags = (short) (label.flags & (-2));
        return label;
    }

    private void createDebugLabel(int bytecodeOffset, Label[] labels) {
        if (labels[bytecodeOffset] == null) {
            Label label = readLabel(bytecodeOffset, labels);
            label.flags = (short) (label.flags | 1);
        }
    }

    private int[] readTypeAnnotations(MethodVisitor methodVisitor, Context context, int runtimeTypeAnnotationsOffset, boolean visible) {
        int currentOffset;
        int elementValues;
        char[] charBuffer = context.charBuffer;
        int[] typeAnnotationsOffsets = new int[readUnsignedShort(runtimeTypeAnnotationsOffset)];
        int currentOffset2 = runtimeTypeAnnotationsOffset + 2;
        for (int i = 0; i < typeAnnotationsOffsets.length; i++) {
            typeAnnotationsOffsets[i] = currentOffset2;
            int targetType = readInt(currentOffset2);
            switch (targetType >>> 24) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 19:
                case 20:
                case 21:
                case 22:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                default:
                    throw new IllegalArgumentException();
                case 16:
                case 17:
                case 18:
                case 23:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                    currentOffset = currentOffset2 + 3;
                    break;
                case 64:
                case 65:
                    int tableLength = readUnsignedShort(currentOffset2 + 1);
                    currentOffset = currentOffset2 + 3;
                    while (true) {
                        int i2 = tableLength;
                        tableLength--;
                        if (i2 > 0) {
                            int startPc = readUnsignedShort(currentOffset);
                            int length = readUnsignedShort(currentOffset + 2);
                            currentOffset += 6;
                            createLabel(startPc, context.currentMethodLabels);
                            createLabel(startPc + length, context.currentMethodLabels);
                        }
                        break;
                    }
                    break;
                case 71:
                case 72:
                case 73:
                case 74:
                case 75:
                    currentOffset = currentOffset2 + 4;
                    break;
            }
            int pathLength = readByte(currentOffset);
            if ((targetType >>> 24) == 66) {
                TypePath path = pathLength == 0 ? null : new TypePath(this.classFileBuffer, currentOffset);
                int currentOffset3 = currentOffset + 1 + (2 * pathLength);
                String annotationDescriptor = readUTF8(currentOffset3, charBuffer);
                elementValues = readElementValues(methodVisitor.visitTryCatchAnnotation(targetType & InputDeviceCompat.SOURCE_ANY, path, annotationDescriptor, visible), currentOffset3 + 2, true, charBuffer);
            } else {
                elementValues = readElementValues(null, currentOffset + 3 + (2 * pathLength), true, charBuffer);
            }
            currentOffset2 = elementValues;
        }
        return typeAnnotationsOffsets;
    }

    private int getTypeAnnotationBytecodeOffset(int[] typeAnnotationOffsets, int typeAnnotationIndex) {
        if (typeAnnotationOffsets == null || typeAnnotationIndex >= typeAnnotationOffsets.length || readByte(typeAnnotationOffsets[typeAnnotationIndex]) < 67) {
            return -1;
        }
        return readUnsignedShort(typeAnnotationOffsets[typeAnnotationIndex] + 1);
    }

    private int readTypeAnnotationTarget(Context context, int typeAnnotationOffset) {
        int targetType;
        int currentOffset;
        int targetType2 = readInt(typeAnnotationOffset);
        switch (targetType2 >>> 24) {
            case 0:
            case 1:
            case 22:
                targetType = targetType2 & (-65536);
                currentOffset = typeAnnotationOffset + 2;
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            default:
                throw new IllegalArgumentException();
            case 16:
            case 17:
            case 18:
            case 23:
            case 66:
                targetType = targetType2 & InputDeviceCompat.SOURCE_ANY;
                currentOffset = typeAnnotationOffset + 3;
                break;
            case 19:
            case 20:
            case 21:
                targetType = targetType2 & ViewCompat.MEASURED_STATE_MASK;
                currentOffset = typeAnnotationOffset + 1;
                break;
            case 64:
            case 65:
                targetType = targetType2 & ViewCompat.MEASURED_STATE_MASK;
                int tableLength = readUnsignedShort(typeAnnotationOffset + 1);
                currentOffset = typeAnnotationOffset + 3;
                context.currentLocalVariableAnnotationRangeStarts = new Label[tableLength];
                context.currentLocalVariableAnnotationRangeEnds = new Label[tableLength];
                context.currentLocalVariableAnnotationRangeIndices = new int[tableLength];
                for (int i = 0; i < tableLength; i++) {
                    int startPc = readUnsignedShort(currentOffset);
                    int length = readUnsignedShort(currentOffset + 2);
                    int index = readUnsignedShort(currentOffset + 4);
                    currentOffset += 6;
                    context.currentLocalVariableAnnotationRangeStarts[i] = createLabel(startPc, context.currentMethodLabels);
                    context.currentLocalVariableAnnotationRangeEnds[i] = createLabel(startPc + length, context.currentMethodLabels);
                    context.currentLocalVariableAnnotationRangeIndices[i] = index;
                }
                break;
            case 67:
            case 68:
            case 69:
            case 70:
                targetType = targetType2 & ViewCompat.MEASURED_STATE_MASK;
                currentOffset = typeAnnotationOffset + 3;
                break;
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
                targetType = targetType2 & (-16776961);
                currentOffset = typeAnnotationOffset + 4;
                break;
        }
        context.currentTypeAnnotationTarget = targetType;
        int pathLength = readByte(currentOffset);
        context.currentTypeAnnotationTargetPath = pathLength == 0 ? null : new TypePath(this.classFileBuffer, currentOffset);
        return currentOffset + 1 + (2 * pathLength);
    }

    private void readParameterAnnotations(MethodVisitor methodVisitor, Context context, int runtimeParameterAnnotationsOffset, boolean visible) {
        int currentOffset = runtimeParameterAnnotationsOffset + 1;
        int numParameters = this.classFileBuffer[runtimeParameterAnnotationsOffset] & 255;
        methodVisitor.visitAnnotableParameterCount(numParameters, visible);
        char[] charBuffer = context.charBuffer;
        for (int i = 0; i < numParameters; i++) {
            int numAnnotations = readUnsignedShort(currentOffset);
            currentOffset += 2;
            while (true) {
                int i2 = numAnnotations;
                numAnnotations--;
                if (i2 > 0) {
                    String annotationDescriptor = readUTF8(currentOffset, charBuffer);
                    currentOffset = readElementValues(methodVisitor.visitParameterAnnotation(i, annotationDescriptor, visible), currentOffset + 2, true, charBuffer);
                }
            }
        }
    }

    private int readElementValues(AnnotationVisitor annotationVisitor, int annotationOffset, boolean named, char[] charBuffer) {
        int numElementValuePairs = readUnsignedShort(annotationOffset);
        int currentOffset = annotationOffset + 2;
        if (!named) {
            while (true) {
                int i = numElementValuePairs;
                numElementValuePairs--;
                if (i <= 0) {
                    break;
                }
                currentOffset = readElementValue(annotationVisitor, currentOffset, null, charBuffer);
            }
        } else {
            while (true) {
                int i2 = numElementValuePairs;
                numElementValuePairs--;
                if (i2 <= 0) {
                    break;
                }
                String elementName = readUTF8(currentOffset, charBuffer);
                currentOffset = readElementValue(annotationVisitor, currentOffset + 2, elementName, charBuffer);
            }
        }
        if (annotationVisitor != null) {
            annotationVisitor.visitEnd();
        }
        return currentOffset;
    }

    private int readElementValue(AnnotationVisitor annotationVisitor, int elementValueOffset, String elementName, char[] charBuffer) {
        int currentOffset;
        if (annotationVisitor != null) {
            int currentOffset2 = elementValueOffset + 1;
            switch (this.classFileBuffer[elementValueOffset] & 255) {
                case 64:
                    currentOffset = readElementValues(annotationVisitor.visitAnnotation(elementName, readUTF8(currentOffset2, charBuffer)), currentOffset2 + 2, true, charBuffer);
                    break;
                case 65:
                case 69:
                case 71:
                case 72:
                case 75:
                case 76:
                case 77:
                case 78:
                case 79:
                case 80:
                case 81:
                case 82:
                case 84:
                case 85:
                case 86:
                case 87:
                case 88:
                case 89:
                case 92:
                case 93:
                case 94:
                case 95:
                case 96:
                case 97:
                case 98:
                case 100:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                case 107:
                case 108:
                case 109:
                case 110:
                case 111:
                case 112:
                case 113:
                case 114:
                default:
                    throw new IllegalArgumentException();
                case 66:
                    annotationVisitor.visit(elementName, Byte.valueOf((byte) readInt(this.cpInfoOffsets[readUnsignedShort(currentOffset2)])));
                    currentOffset = currentOffset2 + 2;
                    break;
                case 67:
                    annotationVisitor.visit(elementName, Character.valueOf((char) readInt(this.cpInfoOffsets[readUnsignedShort(currentOffset2)])));
                    currentOffset = currentOffset2 + 2;
                    break;
                case 68:
                case 70:
                case 73:
                case 74:
                    annotationVisitor.visit(elementName, readConst(readUnsignedShort(currentOffset2), charBuffer));
                    currentOffset = currentOffset2 + 2;
                    break;
                case 83:
                    annotationVisitor.visit(elementName, Short.valueOf((short) readInt(this.cpInfoOffsets[readUnsignedShort(currentOffset2)])));
                    currentOffset = currentOffset2 + 2;
                    break;
                case 90:
                    annotationVisitor.visit(elementName, readInt(this.cpInfoOffsets[readUnsignedShort(currentOffset2)]) == 0 ? Boolean.FALSE : Boolean.TRUE);
                    currentOffset = currentOffset2 + 2;
                    break;
                case 91:
                    int numValues = readUnsignedShort(currentOffset2);
                    currentOffset = currentOffset2 + 2;
                    if (numValues == 0) {
                        return readElementValues(annotationVisitor.visitArray(elementName), currentOffset - 2, false, charBuffer);
                    }
                    switch (this.classFileBuffer[currentOffset] & 255) {
                        case 66:
                            byte[] byteValues = new byte[numValues];
                            for (int i = 0; i < numValues; i++) {
                                byteValues[i] = (byte) readInt(this.cpInfoOffsets[readUnsignedShort(currentOffset + 1)]);
                                currentOffset += 3;
                            }
                            annotationVisitor.visit(elementName, byteValues);
                            break;
                        case 67:
                            char[] charValues = new char[numValues];
                            for (int i2 = 0; i2 < numValues; i2++) {
                                charValues[i2] = (char) readInt(this.cpInfoOffsets[readUnsignedShort(currentOffset + 1)]);
                                currentOffset += 3;
                            }
                            annotationVisitor.visit(elementName, charValues);
                            break;
                        case 68:
                            double[] doubleValues = new double[numValues];
                            for (int i3 = 0; i3 < numValues; i3++) {
                                doubleValues[i3] = Double.longBitsToDouble(readLong(this.cpInfoOffsets[readUnsignedShort(currentOffset + 1)]));
                                currentOffset += 3;
                            }
                            annotationVisitor.visit(elementName, doubleValues);
                            break;
                        case 69:
                        case 71:
                        case 72:
                        case 75:
                        case 76:
                        case 77:
                        case 78:
                        case 79:
                        case 80:
                        case 81:
                        case 82:
                        case 84:
                        case 85:
                        case 86:
                        case 87:
                        case 88:
                        case 89:
                        default:
                            currentOffset = readElementValues(annotationVisitor.visitArray(elementName), currentOffset - 2, false, charBuffer);
                            break;
                        case 70:
                            float[] floatValues = new float[numValues];
                            for (int i4 = 0; i4 < numValues; i4++) {
                                floatValues[i4] = Float.intBitsToFloat(readInt(this.cpInfoOffsets[readUnsignedShort(currentOffset + 1)]));
                                currentOffset += 3;
                            }
                            annotationVisitor.visit(elementName, floatValues);
                            break;
                        case 73:
                            int[] intValues = new int[numValues];
                            for (int i5 = 0; i5 < numValues; i5++) {
                                intValues[i5] = readInt(this.cpInfoOffsets[readUnsignedShort(currentOffset + 1)]);
                                currentOffset += 3;
                            }
                            annotationVisitor.visit(elementName, intValues);
                            break;
                        case 74:
                            long[] longValues = new long[numValues];
                            for (int i6 = 0; i6 < numValues; i6++) {
                                longValues[i6] = readLong(this.cpInfoOffsets[readUnsignedShort(currentOffset + 1)]);
                                currentOffset += 3;
                            }
                            annotationVisitor.visit(elementName, longValues);
                            break;
                        case 83:
                            short[] shortValues = new short[numValues];
                            for (int i7 = 0; i7 < numValues; i7++) {
                                shortValues[i7] = (short) readInt(this.cpInfoOffsets[readUnsignedShort(currentOffset + 1)]);
                                currentOffset += 3;
                            }
                            annotationVisitor.visit(elementName, shortValues);
                            break;
                        case 90:
                            boolean[] booleanValues = new boolean[numValues];
                            for (int i8 = 0; i8 < numValues; i8++) {
                                booleanValues[i8] = readInt(this.cpInfoOffsets[readUnsignedShort(currentOffset + 1)]) != 0;
                                currentOffset += 3;
                            }
                            annotationVisitor.visit(elementName, booleanValues);
                            break;
                    }
                    break;
                case 99:
                    annotationVisitor.visit(elementName, Type.getType(readUTF8(currentOffset2, charBuffer)));
                    currentOffset = currentOffset2 + 2;
                    break;
                case 101:
                    annotationVisitor.visitEnum(elementName, readUTF8(currentOffset2, charBuffer), readUTF8(currentOffset2 + 2, charBuffer));
                    currentOffset = currentOffset2 + 4;
                    break;
                case 115:
                    annotationVisitor.visit(elementName, readUTF8(currentOffset2, charBuffer));
                    currentOffset = currentOffset2 + 2;
                    break;
            }
            return currentOffset;
        }
        switch (this.classFileBuffer[elementValueOffset] & 255) {
            case 64:
                return readElementValues(null, elementValueOffset + 3, true, charBuffer);
            case 91:
                return readElementValues(null, elementValueOffset + 1, false, charBuffer);
            case 101:
                return elementValueOffset + 5;
            default:
                return elementValueOffset + 3;
        }
    }

    private void computeImplicitFrame(Context context) {
        String methodDescriptor = context.currentMethodDescriptor;
        Object[] locals = context.currentFrameLocalTypes;
        int numLocal = 0;
        if ((context.currentMethodAccessFlags & 8) == 0) {
            if ("<init>".equals(context.currentMethodName)) {
                numLocal = 0 + 1;
                locals[0] = Opcodes.UNINITIALIZED_THIS;
            } else {
                numLocal = 0 + 1;
                locals[0] = readClass(this.header + 2, context.charBuffer);
            }
        }
        int currentMethodDescritorOffset = 1;
        while (true) {
            int currentArgumentDescriptorStartOffset = currentMethodDescritorOffset;
            int i = currentMethodDescritorOffset;
            currentMethodDescritorOffset++;
            switch (methodDescriptor.charAt(i)) {
                case 'B':
                case 'C':
                case 'I':
                case 'S':
                case 'Z':
                    int i2 = numLocal;
                    numLocal++;
                    locals[i2] = Opcodes.INTEGER;
                    break;
                case 'D':
                    int i3 = numLocal;
                    numLocal++;
                    locals[i3] = Opcodes.DOUBLE;
                    break;
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
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                default:
                    context.currentFrameLocalCount = numLocal;
                    return;
                case 'F':
                    int i4 = numLocal;
                    numLocal++;
                    locals[i4] = Opcodes.FLOAT;
                    break;
                case 'J':
                    int i5 = numLocal;
                    numLocal++;
                    locals[i5] = Opcodes.LONG;
                    break;
                case 'L':
                    while (methodDescriptor.charAt(currentMethodDescritorOffset) != ';') {
                        currentMethodDescritorOffset++;
                    }
                    int i6 = numLocal;
                    numLocal++;
                    int i7 = currentMethodDescritorOffset;
                    currentMethodDescritorOffset++;
                    locals[i6] = methodDescriptor.substring(currentArgumentDescriptorStartOffset + 1, i7);
                    break;
                case '[':
                    while (methodDescriptor.charAt(currentMethodDescritorOffset) == '[') {
                        currentMethodDescritorOffset++;
                    }
                    if (methodDescriptor.charAt(currentMethodDescritorOffset) == 'L') {
                        do {
                            currentMethodDescritorOffset++;
                        } while (methodDescriptor.charAt(currentMethodDescritorOffset) != ';');
                    }
                    int i8 = numLocal;
                    numLocal++;
                    currentMethodDescritorOffset++;
                    locals[i8] = methodDescriptor.substring(currentArgumentDescriptorStartOffset, currentMethodDescritorOffset);
                    break;
            }
        }
    }

    private int readStackMapFrame(int stackMapFrameOffset, boolean compressed, boolean expand, Context context) {
        int frameType;
        int offsetDelta;
        int currentOffset = stackMapFrameOffset;
        char[] charBuffer = context.charBuffer;
        Label[] labels = context.currentMethodLabels;
        if (compressed) {
            currentOffset++;
            frameType = this.classFileBuffer[currentOffset] & 255;
        } else {
            frameType = 255;
            context.currentFrameOffset = -1;
        }
        context.currentFrameLocalCountDelta = 0;
        if (frameType < 64) {
            offsetDelta = frameType;
            context.currentFrameType = 3;
            context.currentFrameStackCount = 0;
        } else if (frameType < 128) {
            offsetDelta = frameType - 64;
            currentOffset = readVerificationTypeInfo(currentOffset, context.currentFrameStackTypes, 0, charBuffer, labels);
            context.currentFrameType = 4;
            context.currentFrameStackCount = 1;
        } else if (frameType >= 247) {
            offsetDelta = readUnsignedShort(currentOffset);
            currentOffset += 2;
            if (frameType == 247) {
                currentOffset = readVerificationTypeInfo(currentOffset, context.currentFrameStackTypes, 0, charBuffer, labels);
                context.currentFrameType = 4;
                context.currentFrameStackCount = 1;
            } else if (frameType >= 248 && frameType < 251) {
                context.currentFrameType = 2;
                context.currentFrameLocalCountDelta = 251 - frameType;
                context.currentFrameLocalCount -= context.currentFrameLocalCountDelta;
                context.currentFrameStackCount = 0;
            } else if (frameType == 251) {
                context.currentFrameType = 3;
                context.currentFrameStackCount = 0;
            } else if (frameType < 255) {
                int local = expand ? context.currentFrameLocalCount : 0;
                for (int k = frameType - 251; k > 0; k--) {
                    int i = local;
                    local++;
                    currentOffset = readVerificationTypeInfo(currentOffset, context.currentFrameLocalTypes, i, charBuffer, labels);
                }
                context.currentFrameType = 1;
                context.currentFrameLocalCountDelta = frameType - 251;
                context.currentFrameLocalCount += context.currentFrameLocalCountDelta;
                context.currentFrameStackCount = 0;
            } else {
                int numberOfLocals = readUnsignedShort(currentOffset);
                int currentOffset2 = currentOffset + 2;
                context.currentFrameType = 0;
                context.currentFrameLocalCountDelta = numberOfLocals;
                context.currentFrameLocalCount = numberOfLocals;
                for (int local2 = 0; local2 < numberOfLocals; local2++) {
                    currentOffset2 = readVerificationTypeInfo(currentOffset2, context.currentFrameLocalTypes, local2, charBuffer, labels);
                }
                int numberOfStackItems = readUnsignedShort(currentOffset2);
                currentOffset = currentOffset2 + 2;
                context.currentFrameStackCount = numberOfStackItems;
                for (int stack = 0; stack < numberOfStackItems; stack++) {
                    currentOffset = readVerificationTypeInfo(currentOffset, context.currentFrameStackTypes, stack, charBuffer, labels);
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
        context.currentFrameOffset += offsetDelta + 1;
        createLabel(context.currentFrameOffset, labels);
        return currentOffset;
    }

    private int readVerificationTypeInfo(int verificationTypeInfoOffset, Object[] frame, int index, char[] charBuffer, Label[] labels) {
        int currentOffset = verificationTypeInfoOffset + 1;
        int tag = this.classFileBuffer[verificationTypeInfoOffset] & 255;
        switch (tag) {
            case 0:
                frame[index] = Opcodes.TOP;
                break;
            case 1:
                frame[index] = Opcodes.INTEGER;
                break;
            case 2:
                frame[index] = Opcodes.FLOAT;
                break;
            case 3:
                frame[index] = Opcodes.DOUBLE;
                break;
            case 4:
                frame[index] = Opcodes.LONG;
                break;
            case 5:
                frame[index] = Opcodes.NULL;
                break;
            case 6:
                frame[index] = Opcodes.UNINITIALIZED_THIS;
                break;
            case 7:
                frame[index] = readClass(currentOffset, charBuffer);
                currentOffset += 2;
                break;
            case 8:
                frame[index] = createLabel(readUnsignedShort(currentOffset), labels);
                currentOffset += 2;
                break;
            default:
                throw new IllegalArgumentException();
        }
        return currentOffset;
    }

    final int getFirstAttributeOffset() {
        int currentOffset = this.header + 8 + (readUnsignedShort(this.header + 6) * 2);
        int fieldsCount = readUnsignedShort(currentOffset);
        int currentOffset2 = currentOffset + 2;
        while (true) {
            int i = fieldsCount;
            fieldsCount--;
            if (i <= 0) {
                break;
            }
            int attributesCount = readUnsignedShort(currentOffset2 + 6);
            currentOffset2 += 8;
            while (true) {
                int i2 = attributesCount;
                attributesCount--;
                if (i2 > 0) {
                    currentOffset2 += 6 + readInt(currentOffset2 + 2);
                }
            }
        }
        int methodsCount = readUnsignedShort(currentOffset2);
        int currentOffset3 = currentOffset2 + 2;
        while (true) {
            int i3 = methodsCount;
            methodsCount--;
            if (i3 > 0) {
                int attributesCount2 = readUnsignedShort(currentOffset3 + 6);
                currentOffset3 += 8;
                while (true) {
                    int i4 = attributesCount2;
                    attributesCount2--;
                    if (i4 > 0) {
                        currentOffset3 += 6 + readInt(currentOffset3 + 2);
                    }
                }
            } else {
                return currentOffset3 + 2;
            }
        }
    }

    private int[] readBootstrapMethodsAttribute(int maxStringLength) {
        char[] charBuffer = new char[maxStringLength];
        int currentAttributeOffset = getFirstAttributeOffset();
        for (int i = readUnsignedShort(currentAttributeOffset - 2); i > 0; i--) {
            String attributeName = readUTF8(currentAttributeOffset, charBuffer);
            int attributeLength = readInt(currentAttributeOffset + 2);
            int currentAttributeOffset2 = currentAttributeOffset + 6;
            if ("BootstrapMethods".equals(attributeName)) {
                int[] currentBootstrapMethodOffsets = new int[readUnsignedShort(currentAttributeOffset2)];
                int currentBootstrapMethodOffset = currentAttributeOffset2 + 2;
                for (int j = 0; j < currentBootstrapMethodOffsets.length; j++) {
                    currentBootstrapMethodOffsets[j] = currentBootstrapMethodOffset;
                    currentBootstrapMethodOffset += 4 + (readUnsignedShort(currentBootstrapMethodOffset + 2) * 2);
                }
                return currentBootstrapMethodOffsets;
            }
            currentAttributeOffset = currentAttributeOffset2 + attributeLength;
        }
        throw new IllegalArgumentException();
    }

    private Attribute readAttribute(Attribute[] attributePrototypes, String type, int offset, int length, char[] charBuffer, int codeAttributeOffset, Label[] labels) {
        for (Attribute attributePrototype : attributePrototypes) {
            if (attributePrototype.type.equals(type)) {
                return attributePrototype.read(this, offset, length, charBuffer, codeAttributeOffset, labels);
            }
        }
        return new Attribute(type).read(this, offset, length, null, -1, null);
    }

    public int getItemCount() {
        return this.cpInfoOffsets.length;
    }

    public int getItem(int constantPoolEntryIndex) {
        return this.cpInfoOffsets[constantPoolEntryIndex];
    }

    public int getMaxStringLength() {
        return this.maxStringLength;
    }

    public int readByte(int offset) {
        return this.classFileBuffer[offset] & 255;
    }

    public int readUnsignedShort(int offset) {
        byte[] classBuffer = this.classFileBuffer;
        return ((classBuffer[offset] & 255) << 8) | (classBuffer[offset + 1] & 255);
    }

    public short readShort(int offset) {
        byte[] classBuffer = this.classFileBuffer;
        return (short) (((classBuffer[offset] & 255) << 8) | (classBuffer[offset + 1] & 255));
    }

    public int readInt(int offset) {
        byte[] classBuffer = this.classFileBuffer;
        return ((classBuffer[offset] & 255) << 24) | ((classBuffer[offset + 1] & 255) << 16) | ((classBuffer[offset + 2] & 255) << 8) | (classBuffer[offset + 3] & 255);
    }

    public long readLong(int offset) {
        long l1 = readInt(offset);
        long l0 = ((long) readInt(offset + 4)) & 4294967295L;
        return (l1 << 32) | l0;
    }

    public String readUTF8(int offset, char[] charBuffer) {
        int constantPoolEntryIndex = readUnsignedShort(offset);
        if (offset == 0 || constantPoolEntryIndex == 0) {
            return null;
        }
        return readUtf(constantPoolEntryIndex, charBuffer);
    }

    final String readUtf(int constantPoolEntryIndex, char[] charBuffer) {
        String value = this.constantUtf8Values[constantPoolEntryIndex];
        if (value != null) {
            return value;
        }
        int cpInfoOffset = this.cpInfoOffsets[constantPoolEntryIndex];
        String[] strArr = this.constantUtf8Values;
        String utf = readUtf(cpInfoOffset + 2, readUnsignedShort(cpInfoOffset), charBuffer);
        strArr[constantPoolEntryIndex] = utf;
        return utf;
    }

    private String readUtf(int utfOffset, int utfLength, char[] charBuffer) {
        int currentOffset = utfOffset;
        int endOffset = currentOffset + utfLength;
        int strLength = 0;
        byte[] classBuffer = this.classFileBuffer;
        while (currentOffset < endOffset) {
            int i = currentOffset;
            currentOffset++;
            byte b2 = classBuffer[i];
            if ((b2 & 128) == 0) {
                int i2 = strLength;
                strLength++;
                charBuffer[i2] = (char) (b2 & 127);
            } else if ((b2 & 224) == 192) {
                int i3 = strLength;
                strLength++;
                currentOffset++;
                charBuffer[i3] = (char) (((b2 & 31) << 6) + (classBuffer[currentOffset] & 63));
            } else {
                int i4 = strLength;
                strLength++;
                int currentOffset2 = currentOffset + 1;
                int i5 = ((b2 & 15) << 12) + ((classBuffer[currentOffset] & 63) << 6);
                currentOffset = currentOffset2 + 1;
                charBuffer[i4] = (char) (i5 + (classBuffer[currentOffset2] & 63));
            }
        }
        return new String(charBuffer, 0, strLength);
    }

    private String readStringish(int offset, char[] charBuffer) {
        return readUTF8(this.cpInfoOffsets[readUnsignedShort(offset)], charBuffer);
    }

    public String readClass(int offset, char[] charBuffer) {
        return readStringish(offset, charBuffer);
    }

    public String readModule(int offset, char[] charBuffer) {
        return readStringish(offset, charBuffer);
    }

    public String readPackage(int offset, char[] charBuffer) {
        return readStringish(offset, charBuffer);
    }

    private ConstantDynamic readConstantDynamic(int constantPoolEntryIndex, char[] charBuffer) {
        ConstantDynamic constantDynamic = this.constantDynamicValues[constantPoolEntryIndex];
        if (constantDynamic != null) {
            return constantDynamic;
        }
        int cpInfoOffset = this.cpInfoOffsets[constantPoolEntryIndex];
        int nameAndTypeCpInfoOffset = this.cpInfoOffsets[readUnsignedShort(cpInfoOffset + 2)];
        String name = readUTF8(nameAndTypeCpInfoOffset, charBuffer);
        String descriptor = readUTF8(nameAndTypeCpInfoOffset + 2, charBuffer);
        int bootstrapMethodOffset = this.bootstrapMethodOffsets[readUnsignedShort(cpInfoOffset)];
        Handle handle = (Handle) readConst(readUnsignedShort(bootstrapMethodOffset), charBuffer);
        Object[] bootstrapMethodArguments = new Object[readUnsignedShort(bootstrapMethodOffset + 2)];
        int bootstrapMethodOffset2 = bootstrapMethodOffset + 4;
        for (int i = 0; i < bootstrapMethodArguments.length; i++) {
            bootstrapMethodArguments[i] = readConst(readUnsignedShort(bootstrapMethodOffset2), charBuffer);
            bootstrapMethodOffset2 += 2;
        }
        ConstantDynamic[] constantDynamicArr = this.constantDynamicValues;
        ConstantDynamic constantDynamic2 = new ConstantDynamic(name, descriptor, handle, bootstrapMethodArguments);
        constantDynamicArr[constantPoolEntryIndex] = constantDynamic2;
        return constantDynamic2;
    }

    public Object readConst(int constantPoolEntryIndex, char[] charBuffer) {
        int cpInfoOffset = this.cpInfoOffsets[constantPoolEntryIndex];
        switch (this.classFileBuffer[cpInfoOffset - 1]) {
            case 3:
                return Integer.valueOf(readInt(cpInfoOffset));
            case 4:
                return Float.valueOf(Float.intBitsToFloat(readInt(cpInfoOffset)));
            case 5:
                return Long.valueOf(readLong(cpInfoOffset));
            case 6:
                return Double.valueOf(Double.longBitsToDouble(readLong(cpInfoOffset)));
            case 7:
                return Type.getObjectType(readUTF8(cpInfoOffset, charBuffer));
            case 8:
                return readUTF8(cpInfoOffset, charBuffer);
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            default:
                throw new IllegalArgumentException();
            case 15:
                int referenceKind = readByte(cpInfoOffset);
                int referenceCpInfoOffset = this.cpInfoOffsets[readUnsignedShort(cpInfoOffset + 1)];
                int nameAndTypeCpInfoOffset = this.cpInfoOffsets[readUnsignedShort(referenceCpInfoOffset + 2)];
                String owner = readClass(referenceCpInfoOffset, charBuffer);
                String name = readUTF8(nameAndTypeCpInfoOffset, charBuffer);
                String descriptor = readUTF8(nameAndTypeCpInfoOffset + 2, charBuffer);
                boolean isInterface = this.classFileBuffer[referenceCpInfoOffset - 1] == 11;
                return new Handle(referenceKind, owner, name, descriptor, isInterface);
            case 16:
                return Type.getMethodType(readUTF8(cpInfoOffset, charBuffer));
            case 17:
                return readConstantDynamic(constantPoolEntryIndex, charBuffer);
        }
    }
}
