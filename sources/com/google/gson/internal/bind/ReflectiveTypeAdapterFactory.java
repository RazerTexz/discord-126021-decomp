package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.Excluder;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p007b.p225i.p408d.C4898b;
import p007b.p225i.p408d.InterfaceC4897a;
import p007b.p225i.p408d.InterfaceC4900d;
import p007b.p225i.p408d.InterfaceC4911o;
import p007b.p225i.p408d.p409p.InterfaceC4914c;
import p007b.p225i.p408d.p409p.InterfaceC4915d;
import p007b.p225i.p408d.p410q.C4922g;
import p007b.p225i.p408d.p410q.InterfaceC4933r;
import p007b.p225i.p408d.p410q.p413y.AbstractC4944b;

/* JADX INFO: loaded from: classes3.dex */
public final class ReflectiveTypeAdapterFactory implements InterfaceC4911o {

    /* JADX INFO: renamed from: j */
    public final C4922g f21527j;

    /* JADX INFO: renamed from: k */
    public final InterfaceC4900d f21528k;

    /* JADX INFO: renamed from: l */
    public final Excluder f21529l;

    /* JADX INFO: renamed from: m */
    public final JsonAdapterAnnotationTypeAdapterFactory f21530m;

    /* JADX INFO: renamed from: n */
    public final AbstractC4944b f21531n = AbstractC4944b.f13148a;

    public static final class Adapter<T> extends TypeAdapter<T> {

        /* JADX INFO: renamed from: a */
        public final InterfaceC4933r<T> f21532a;

        /* JADX INFO: renamed from: b */
        public final Map<String, AbstractC11109a> f21533b;

        public Adapter(InterfaceC4933r<T> interfaceC4933r, Map<String, AbstractC11109a> map) {
            this.f21532a = interfaceC4933r;
            this.f21533b = map;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo6878N() == JsonToken.NULL) {
                jsonReader.mo6876H();
                return null;
            }
            T tMo6869a = this.f21532a.mo6869a();
            try {
                jsonReader.mo6883b();
                while (jsonReader.mo6888q()) {
                    AbstractC11109a abstractC11109a = this.f21533b.get(jsonReader.mo6875C());
                    if (abstractC11109a == null || !abstractC11109a.f21536c) {
                        jsonReader.mo6879U();
                    } else {
                        abstractC11109a.mo6906a(jsonReader, tMo6869a);
                    }
                }
                jsonReader.mo6887f();
                return tMo6869a;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            if (t == null) {
                jsonWriter.mo6905s();
                return;
            }
            jsonWriter.mo6901c();
            try {
                for (AbstractC11109a abstractC11109a : this.f21533b.values()) {
                    if (abstractC11109a.mo6908c(t)) {
                        jsonWriter.mo6904n(abstractC11109a.f21534a);
                        abstractC11109a.mo6907b(jsonWriter, t);
                    }
                }
                jsonWriter.mo6903f();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$a */
    public static abstract class AbstractC11109a {

        /* JADX INFO: renamed from: a */
        public final String f21534a;

        /* JADX INFO: renamed from: b */
        public final boolean f21535b;

        /* JADX INFO: renamed from: c */
        public final boolean f21536c;

        public AbstractC11109a(String str, boolean z2, boolean z3) {
            this.f21534a = str;
            this.f21535b = z2;
            this.f21536c = z3;
        }

        /* JADX INFO: renamed from: a */
        public abstract void mo6906a(JsonReader jsonReader, Object obj) throws IllegalAccessException, IOException;

        /* JADX INFO: renamed from: b */
        public abstract void mo6907b(JsonWriter jsonWriter, Object obj) throws IllegalAccessException, IOException;

        /* JADX INFO: renamed from: c */
        public abstract boolean mo6908c(Object obj) throws IllegalAccessException, IOException;
    }

    public ReflectiveTypeAdapterFactory(C4922g c4922g, InterfaceC4900d interfaceC4900d, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.f21527j = c4922g;
        this.f21528k = interfaceC4900d;
        this.f21529l = excluder;
        this.f21530m = jsonAdapterAnnotationTypeAdapterFactory;
    }

    /* JADX INFO: renamed from: a */
    public boolean m9233a(Field field, boolean z2) {
        boolean z3;
        Excluder excluder = this.f21529l;
        Class<?> type = field.getType();
        if (!(excluder.m9217b(type) || excluder.m9218f(type, z2))) {
            if ((excluder.f21485l & field.getModifiers()) == 0 && ((excluder.f21484k == -1.0d || excluder.m9221i((InterfaceC4914c) field.getAnnotation(InterfaceC4914c.class), (InterfaceC4915d) field.getAnnotation(InterfaceC4915d.class))) && !field.isSynthetic() && ((excluder.f21486m || !excluder.m9220h(field.getType())) && !excluder.m9219g(field.getType())))) {
                List<InterfaceC4897a> list = z2 ? excluder.f21487n : excluder.f21488o;
                if (!list.isEmpty()) {
                    C4898b c4898b = new C4898b(field);
                    Iterator<InterfaceC4897a> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().m6846a(c4898b)) {
                                z3 = true;
                            }
                        }
                    }
                }
                z3 = false;
            } else {
                z3 = true;
            }
            if (!z3) {
                return true;
            }
        }
        return false;
    }

    /*  JADX ERROR: NullPointerException in pass: ConstructorVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(jadx.core.dex.instructions.args.InsnArg)" because "resultArg" is null
        	at jadx.core.dex.visitors.MoveInlineVisitor.processMove(MoveInlineVisitor.java:52)
        	at jadx.core.dex.visitors.MoveInlineVisitor.moveInline(MoveInlineVisitor.java:41)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:43)
        */
    @Override // p007b.p225i.p408d.InterfaceC4911o
    public <T> com.google.gson.TypeAdapter<T> create(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r36v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
        */
    /*  JADX ERROR: NullPointerException in pass: ConstructorVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(jadx.core.dex.instructions.args.InsnArg)" because "resultArg" is null
        	at jadx.core.dex.visitors.MoveInlineVisitor.processMove(MoveInlineVisitor.java:52)
        	at jadx.core.dex.visitors.MoveInlineVisitor.moveInline(MoveInlineVisitor.java:41)
        */
}
