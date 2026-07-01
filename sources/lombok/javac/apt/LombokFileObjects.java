package lombok.javac.apt;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import lombok.core.DiagnosticsReceiver;
import lombok.permit.Permit;

/* JADX INFO: loaded from: app.apk:lombok/javac/apt/LombokFileObjects.SCL.lombok */
final class LombokFileObjects {
    private static final List<String> KNOWN_JAVA9_FILE_MANAGERS = Arrays.asList("com.google.errorprone.MaskedClassLoader$MaskedFileManager", "com.google.devtools.build.buildjar.javac.BlazeJavacMain$ClassloaderMaskingFileManager", "com.google.devtools.build.java.turbine.javac.JavacTurbineCompiler$ClassloaderMaskingFileManager", "org.netbeans.modules.java.source.parsing.ProxyFileManager", "com.sun.tools.javac.api.ClientCodeWrapper$WrappedStandardJavaFileManager", "com.sun.tools.javac.main.DelegatingJavaFileManager$DelegatingSJFM");
    private static Constructor<?> j9CompilerConstructor = null;

    /* JADX INFO: loaded from: app.apk:lombok/javac/apt/LombokFileObjects$Compiler.SCL.lombok */
    interface Compiler {
        public static final Compiler JAVAC6 = new Compiler() { // from class: lombok.javac.apt.LombokFileObjects.Compiler.1
            private Method decoderMethod = null;
            private final AtomicBoolean decoderIsSet = new AtomicBoolean();

            @Override // lombok.javac.apt.LombokFileObjects.Compiler
            public JavaFileObject wrap(LombokFileObject fileObject) {
                return new Javac6BaseFileObjectWrapper(fileObject);
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Throwable, java.util.concurrent.atomic.AtomicBoolean] */
            @Override // lombok.javac.apt.LombokFileObjects.Compiler
            public Method getDecoderMethod() {
                ?? r0 = this.decoderIsSet;
                synchronized (r0) {
                    try {
                        if (this.decoderIsSet.get()) {
                            return this.decoderMethod;
                        }
                        this.decoderMethod = LombokFileObjects.getDecoderMethod("com.sun.tools.javac.util.BaseFileObject");
                        this.decoderIsSet.set(true);
                        return this.decoderMethod;
                    } catch (Throwable th) {
                        throw r0;
                    }
                }
            }
        };
        public static final Compiler JAVAC7 = new Compiler() { // from class: lombok.javac.apt.LombokFileObjects.Compiler.2
            private Method decoderMethod = null;
            private final AtomicBoolean decoderIsSet = new AtomicBoolean();

            @Override // lombok.javac.apt.LombokFileObjects.Compiler
            public JavaFileObject wrap(LombokFileObject fileObject) {
                return new Javac7BaseFileObjectWrapper(fileObject);
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Throwable, java.util.concurrent.atomic.AtomicBoolean] */
            @Override // lombok.javac.apt.LombokFileObjects.Compiler
            public Method getDecoderMethod() {
                ?? r0 = this.decoderIsSet;
                synchronized (r0) {
                    try {
                        if (this.decoderIsSet.get()) {
                            return this.decoderMethod;
                        }
                        this.decoderMethod = LombokFileObjects.getDecoderMethod("com.sun.tools.javac.file.BaseFileObject");
                        this.decoderIsSet.set(true);
                        return this.decoderMethod;
                    } catch (Throwable th) {
                        throw r0;
                    }
                }
            }
        };

        JavaFileObject wrap(LombokFileObject lombokFileObject);

        Method getDecoderMethod();
    }

    static Method getDecoderMethod(String className) {
        try {
            return Permit.getMethod(Class.forName(className), "getDecoder", Boolean.TYPE);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }

    private LombokFileObjects() {
    }

    static Compiler getCompiler(JavaFileManager jfm) {
        String jfmClassName = jfm != null ? jfm.getClass().getName() : "null";
        if (!jfmClassName.equals("com.sun.tools.javac.util.DefaultFileManager") && !jfmClassName.equals("com.sun.tools.javac.util.JavacFileManager")) {
            if (jfmClassName.equals("com.sun.tools.javac.file.JavacFileManager")) {
                try {
                    Class<?> superType = Class.forName("com.sun.tools.javac.file.BaseFileManager");
                    if (superType.isInstance(jfm)) {
                        return java9Compiler(jfm);
                    }
                } catch (Throwable unused) {
                }
                return Compiler.JAVAC7;
            }
            if (KNOWN_JAVA9_FILE_MANAGERS.contains(jfmClassName)) {
                try {
                    return java9Compiler(jfm);
                } catch (Throwable unused2) {
                }
            }
            try {
                if (Class.forName("com.sun.tools.javac.file.PathFileObject") == null) {
                    throw new NullPointerException();
                }
                return java9Compiler(jfm);
            } catch (Throwable unused3) {
                try {
                    if (Class.forName("com.sun.tools.javac.file.BaseFileObject") == null) {
                        throw new NullPointerException();
                    }
                    return Compiler.JAVAC7;
                } catch (Throwable unused4) {
                    try {
                        if (Class.forName("com.sun.tools.javac.util.BaseFileObject") == null) {
                            throw new NullPointerException();
                        }
                        return Compiler.JAVAC6;
                    } catch (Throwable unused5) {
                        StringBuilder sb = new StringBuilder(jfmClassName);
                        if (jfm != null) {
                            sb.append(" extends ").append(jfm.getClass().getSuperclass().getName());
                            for (Class<?> cls : jfm.getClass().getInterfaces()) {
                                sb.append(" implements ").append(cls.getName());
                            }
                        }
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
            }
        }
        return Compiler.JAVAC6;
    }

    static JavaFileObject createIntercepting(Compiler compiler, JavaFileObject delegate, String fileName, DiagnosticsReceiver diagnostics) {
        return compiler.wrap(new InterceptingJavaFileObject(delegate, fileName, diagnostics, compiler.getDecoderMethod()));
    }

    private static Compiler java9Compiler(JavaFileManager jfm) {
        try {
            if (j9CompilerConstructor == null) {
                j9CompilerConstructor = Class.forName("lombok.javac.apt.Java9Compiler").getConstructor(JavaFileManager.class);
            }
            return (Compiler) j9CompilerConstructor.newInstance(jfm);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (NoSuchMethodException unused2) {
            return null;
        } catch (InvocationTargetException e3) {
            Throwable t = e3.getCause();
            if (t instanceof RuntimeException) {
                throw ((RuntimeException) t);
            }
            if (t instanceof Error) {
                throw ((Error) t);
            }
            throw new RuntimeException(t);
        }
    }
}
