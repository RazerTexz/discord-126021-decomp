package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.f.t;
import d0.e0.p.d.m0.f.w;
import d0.e0.p.d.m0.i.AbstractParser;
import d0.e0.p.d.m0.i.ByteString3;
import d0.e0.p.d.m0.i.CodedInputStream;
import d0.e0.p.d.m0.i.ExtensionRegistryLite;
import d0.e0.p.d.m0.i.GeneratedMessageLite;
import d0.e0.p.d.m0.i.Internal;
import d0.e0.p.d.m0.i.MessageLiteOrBuilder;
import d0.e0.p.d.m0.i.Parser2;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends GeneratedMessageLite.d<c> implements MessageLiteOrBuilder {
    public static final c j;
    public static Parser2<c> k = new a();
    private int bitField0_;
    private int companionObjectName_;
    private List<d> constructor_;
    private List<g> enumEntry_;
    private int flags_;
    private int fqName_;
    private List<i> function_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int nestedClassNameMemoizedSerializedSize;
    private List<Integer> nestedClassName_;
    private List<n> property_;
    private int sealedSubclassFqNameMemoizedSerializedSize;
    private List<Integer> sealedSubclassFqName_;
    private int supertypeIdMemoizedSerializedSize;
    private List<Integer> supertypeId_;
    private List<q> supertype_;
    private List<r> typeAlias_;
    private List<s> typeParameter_;
    private t typeTable_;
    private final ByteString3 unknownFields;
    private w versionRequirementTable_;
    private List<Integer> versionRequirement_;

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractParser<c> {
        @Override // d0.e0.p.d.m0.i.Parser2
        public c parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new c(codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends GeneratedMessageLite.c<c, b> implements MessageLiteOrBuilder {
        public int m;
        public int o;
        public int p;
        public int n = 6;
        public List<s> q = Collections.emptyList();
        public List<q> r = Collections.emptyList();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public List<Integer> f3393s = Collections.emptyList();
        public List<Integer> t = Collections.emptyList();
        public List<d> u = Collections.emptyList();
        public List<i> v = Collections.emptyList();
        public List<n> w = Collections.emptyList();

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public List<r> f3394x = Collections.emptyList();

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public List<g> f3395y = Collections.emptyList();

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public List<Integer> f3396z = Collections.emptyList();
        public t A = t.getDefaultInstance();
        public List<Integer> B = Collections.emptyList();
        public w C = w.getDefaultInstance();

        public c buildPartial() {
            c cVar = new c(this, (d0.e0.p.d.m0.f.a) null);
            int i = this.m;
            int i2 = (i & 1) != 1 ? 0 : 1;
            cVar.flags_ = this.n;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            cVar.fqName_ = this.o;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            cVar.companionObjectName_ = this.p;
            if ((this.m & 8) == 8) {
                this.q = Collections.unmodifiableList(this.q);
                this.m &= -9;
            }
            cVar.typeParameter_ = this.q;
            if ((this.m & 16) == 16) {
                this.r = Collections.unmodifiableList(this.r);
                this.m &= -17;
            }
            cVar.supertype_ = this.r;
            if ((this.m & 32) == 32) {
                this.f3393s = Collections.unmodifiableList(this.f3393s);
                this.m &= -33;
            }
            cVar.supertypeId_ = this.f3393s;
            if ((this.m & 64) == 64) {
                this.t = Collections.unmodifiableList(this.t);
                this.m &= -65;
            }
            cVar.nestedClassName_ = this.t;
            if ((this.m & 128) == 128) {
                this.u = Collections.unmodifiableList(this.u);
                this.m &= -129;
            }
            cVar.constructor_ = this.u;
            if ((this.m & 256) == 256) {
                this.v = Collections.unmodifiableList(this.v);
                this.m &= -257;
            }
            cVar.function_ = this.v;
            if ((this.m & 512) == 512) {
                this.w = Collections.unmodifiableList(this.w);
                this.m &= -513;
            }
            cVar.property_ = this.w;
            if ((this.m & 1024) == 1024) {
                this.f3394x = Collections.unmodifiableList(this.f3394x);
                this.m &= -1025;
            }
            cVar.typeAlias_ = this.f3394x;
            if ((this.m & 2048) == 2048) {
                this.f3395y = Collections.unmodifiableList(this.f3395y);
                this.m &= -2049;
            }
            cVar.enumEntry_ = this.f3395y;
            if ((this.m & 4096) == 4096) {
                this.f3396z = Collections.unmodifiableList(this.f3396z);
                this.m &= -4097;
            }
            cVar.sealedSubclassFqName_ = this.f3396z;
            if ((i & 8192) == 8192) {
                i2 |= 8;
            }
            cVar.typeTable_ = this.A;
            if ((this.m & 16384) == 16384) {
                this.B = Collections.unmodifiableList(this.B);
                this.m &= -16385;
            }
            cVar.versionRequirement_ = this.B;
            if ((i & 32768) == 32768) {
                i2 |= 16;
            }
            cVar.versionRequirementTable_ = this.C;
            cVar.bitField0_ = i2;
            return cVar;
        }

        public b mergeTypeTable(t tVar) {
            if ((this.m & 8192) != 8192 || this.A == t.getDefaultInstance()) {
                this.A = tVar;
            } else {
                this.A = t.newBuilder(this.A).mergeFrom(tVar).buildPartial();
            }
            this.m |= 8192;
            return this;
        }

        public b mergeVersionRequirementTable(w wVar) {
            if ((this.m & 32768) != 32768 || this.C == w.getDefaultInstance()) {
                this.C = wVar;
            } else {
                this.C = w.newBuilder(this.C).mergeFrom(wVar).buildPartial();
            }
            this.m |= 32768;
            return this;
        }

        public b setCompanionObjectName(int i) {
            this.m |= 4;
            this.p = i;
            return this;
        }

        public b setFlags(int i) {
            this.m |= 1;
            this.n = i;
            return this;
        }

        public b setFqName(int i) {
            this.m |= 2;
            this.o = i;
            return this;
        }

        @Override // d0.e0.p.d.m0.i.MessageLite.a
        public c build() {
            c cVarBuildPartial = buildPartial();
            if (cVarBuildPartial.isInitialized()) {
                return cVarBuildPartial;
            }
            throw new UninitializedMessageException(cVarBuildPartial);
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
        public b mo88clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        public b mergeFrom(c cVar) {
            if (cVar == c.getDefaultInstance()) {
                return this;
            }
            if (cVar.hasFlags()) {
                setFlags(cVar.getFlags());
            }
            if (cVar.hasFqName()) {
                setFqName(cVar.getFqName());
            }
            if (cVar.hasCompanionObjectName()) {
                setCompanionObjectName(cVar.getCompanionObjectName());
            }
            if (!cVar.typeParameter_.isEmpty()) {
                if (this.q.isEmpty()) {
                    this.q = cVar.typeParameter_;
                    this.m &= -9;
                } else {
                    if ((this.m & 8) != 8) {
                        this.q = new ArrayList(this.q);
                        this.m |= 8;
                    }
                    this.q.addAll(cVar.typeParameter_);
                }
            }
            if (!cVar.supertype_.isEmpty()) {
                if (this.r.isEmpty()) {
                    this.r = cVar.supertype_;
                    this.m &= -17;
                } else {
                    if ((this.m & 16) != 16) {
                        this.r = new ArrayList(this.r);
                        this.m |= 16;
                    }
                    this.r.addAll(cVar.supertype_);
                }
            }
            if (!cVar.supertypeId_.isEmpty()) {
                if (this.f3393s.isEmpty()) {
                    this.f3393s = cVar.supertypeId_;
                    this.m &= -33;
                } else {
                    if ((this.m & 32) != 32) {
                        this.f3393s = new ArrayList(this.f3393s);
                        this.m |= 32;
                    }
                    this.f3393s.addAll(cVar.supertypeId_);
                }
            }
            if (!cVar.nestedClassName_.isEmpty()) {
                if (this.t.isEmpty()) {
                    this.t = cVar.nestedClassName_;
                    this.m &= -65;
                } else {
                    if ((this.m & 64) != 64) {
                        this.t = new ArrayList(this.t);
                        this.m |= 64;
                    }
                    this.t.addAll(cVar.nestedClassName_);
                }
            }
            if (!cVar.constructor_.isEmpty()) {
                if (this.u.isEmpty()) {
                    this.u = cVar.constructor_;
                    this.m &= -129;
                } else {
                    if ((this.m & 128) != 128) {
                        this.u = new ArrayList(this.u);
                        this.m |= 128;
                    }
                    this.u.addAll(cVar.constructor_);
                }
            }
            if (!cVar.function_.isEmpty()) {
                if (this.v.isEmpty()) {
                    this.v = cVar.function_;
                    this.m &= -257;
                } else {
                    if ((this.m & 256) != 256) {
                        this.v = new ArrayList(this.v);
                        this.m |= 256;
                    }
                    this.v.addAll(cVar.function_);
                }
            }
            if (!cVar.property_.isEmpty()) {
                if (this.w.isEmpty()) {
                    this.w = cVar.property_;
                    this.m &= -513;
                } else {
                    if ((this.m & 512) != 512) {
                        this.w = new ArrayList(this.w);
                        this.m |= 512;
                    }
                    this.w.addAll(cVar.property_);
                }
            }
            if (!cVar.typeAlias_.isEmpty()) {
                if (this.f3394x.isEmpty()) {
                    this.f3394x = cVar.typeAlias_;
                    this.m &= -1025;
                } else {
                    if ((this.m & 1024) != 1024) {
                        this.f3394x = new ArrayList(this.f3394x);
                        this.m |= 1024;
                    }
                    this.f3394x.addAll(cVar.typeAlias_);
                }
            }
            if (!cVar.enumEntry_.isEmpty()) {
                if (this.f3395y.isEmpty()) {
                    this.f3395y = cVar.enumEntry_;
                    this.m &= -2049;
                } else {
                    if ((this.m & 2048) != 2048) {
                        this.f3395y = new ArrayList(this.f3395y);
                        this.m |= 2048;
                    }
                    this.f3395y.addAll(cVar.enumEntry_);
                }
            }
            if (!cVar.sealedSubclassFqName_.isEmpty()) {
                if (this.f3396z.isEmpty()) {
                    this.f3396z = cVar.sealedSubclassFqName_;
                    this.m &= -4097;
                } else {
                    if ((this.m & 4096) != 4096) {
                        this.f3396z = new ArrayList(this.f3396z);
                        this.m |= 4096;
                    }
                    this.f3396z.addAll(cVar.sealedSubclassFqName_);
                }
            }
            if (cVar.hasTypeTable()) {
                mergeTypeTable(cVar.getTypeTable());
            }
            if (!cVar.versionRequirement_.isEmpty()) {
                if (this.B.isEmpty()) {
                    this.B = cVar.versionRequirement_;
                    this.m &= -16385;
                } else {
                    if ((this.m & 16384) != 16384) {
                        this.B = new ArrayList(this.B);
                        this.m |= 16384;
                    }
                    this.B.addAll(cVar.versionRequirement_);
                }
            }
            if (cVar.hasVersionRequirementTable()) {
                mergeVersionRequirementTable(cVar.getVersionRequirementTable());
            }
            b(cVar);
            setUnknownFields(getUnknownFields().concat(cVar.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
        public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            c cVar = null;
            try {
                try {
                    c partialFrom = c.k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    c cVar2 = (c) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        cVar = cVar2;
                        if (cVar != null) {
                            mergeFrom(cVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (cVar != null) {
                    mergeFrom(cVar);
                }
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public enum EnumC0397c implements Internal.a {
        CLASS(0),
        INTERFACE(1),
        ENUM_CLASS(2),
        ENUM_ENTRY(3),
        ANNOTATION_CLASS(4),
        OBJECT(5),
        COMPANION_OBJECT(6);

        private final int value;

        EnumC0397c(int i) {
            this.value = i;
        }

        @Override // d0.e0.p.d.m0.i.Internal.a
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        c cVar = new c();
        j = cVar;
        cVar.K();
    }

    public c(GeneratedMessageLite.c cVar, d0.e0.p.d.m0.f.a aVar) {
        super(cVar);
        this.supertypeIdMemoizedSerializedSize = -1;
        this.nestedClassNameMemoizedSerializedSize = -1;
        this.sealedSubclassFqNameMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.getUnknownFields();
    }

    public static c getDefaultInstance() {
        return j;
    }

    public static b newBuilder(c cVar) {
        return newBuilder().mergeFrom(cVar);
    }

    public static c parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (c) ((AbstractParser) k).m90parseFrom(inputStream, extensionRegistryLite);
    }

    public final void K() {
        this.flags_ = 6;
        this.fqName_ = 0;
        this.companionObjectName_ = 0;
        this.typeParameter_ = Collections.emptyList();
        this.supertype_ = Collections.emptyList();
        this.supertypeId_ = Collections.emptyList();
        this.nestedClassName_ = Collections.emptyList();
        this.constructor_ = Collections.emptyList();
        this.function_ = Collections.emptyList();
        this.property_ = Collections.emptyList();
        this.typeAlias_ = Collections.emptyList();
        this.enumEntry_ = Collections.emptyList();
        this.sealedSubclassFqName_ = Collections.emptyList();
        this.typeTable_ = t.getDefaultInstance();
        this.versionRequirement_ = Collections.emptyList();
        this.versionRequirementTable_ = w.getDefaultInstance();
    }

    public int getCompanionObjectName() {
        return this.companionObjectName_;
    }

    public d getConstructor(int i) {
        return this.constructor_.get(i);
    }

    public int getConstructorCount() {
        return this.constructor_.size();
    }

    public List<d> getConstructorList() {
        return this.constructor_;
    }

    public g getEnumEntry(int i) {
        return this.enumEntry_.get(i);
    }

    public int getEnumEntryCount() {
        return this.enumEntry_.size();
    }

    public List<g> getEnumEntryList() {
        return this.enumEntry_;
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getFqName() {
        return this.fqName_;
    }

    public i getFunction(int i) {
        return this.function_.get(i);
    }

    public int getFunctionCount() {
        return this.function_.size();
    }

    public List<i> getFunctionList() {
        return this.function_;
    }

    public List<Integer> getNestedClassNameList() {
        return this.nestedClassName_;
    }

    public n getProperty(int i) {
        return this.property_.get(i);
    }

    public int getPropertyCount() {
        return this.property_.size();
    }

    public List<n> getPropertyList() {
        return this.property_;
    }

    public List<Integer> getSealedSubclassFqNameList() {
        return this.sealedSubclassFqName_;
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.flags_) + 0 : 0;
        int iComputeInt32SizeNoTag = 0;
        for (int i2 = 0; i2 < this.supertypeId_.size(); i2++) {
            iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(this.supertypeId_.get(i2).intValue());
        }
        int iComputeMessageSize = iComputeInt32Size + iComputeInt32SizeNoTag;
        if (!getSupertypeIdList().isEmpty()) {
            iComputeMessageSize = iComputeMessageSize + 1 + CodedOutputStream.computeInt32SizeNoTag(iComputeInt32SizeNoTag);
        }
        this.supertypeIdMemoizedSerializedSize = iComputeInt32SizeNoTag;
        if ((this.bitField0_ & 2) == 2) {
            iComputeMessageSize += CodedOutputStream.computeInt32Size(3, this.fqName_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iComputeMessageSize += CodedOutputStream.computeInt32Size(4, this.companionObjectName_);
        }
        for (int i3 = 0; i3 < this.typeParameter_.size(); i3++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(5, this.typeParameter_.get(i3));
        }
        for (int i4 = 0; i4 < this.supertype_.size(); i4++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(6, this.supertype_.get(i4));
        }
        int iComputeInt32SizeNoTag2 = 0;
        for (int i5 = 0; i5 < this.nestedClassName_.size(); i5++) {
            iComputeInt32SizeNoTag2 += CodedOutputStream.computeInt32SizeNoTag(this.nestedClassName_.get(i5).intValue());
        }
        int iComputeMessageSize2 = iComputeMessageSize + iComputeInt32SizeNoTag2;
        if (!getNestedClassNameList().isEmpty()) {
            iComputeMessageSize2 = iComputeMessageSize2 + 1 + CodedOutputStream.computeInt32SizeNoTag(iComputeInt32SizeNoTag2);
        }
        this.nestedClassNameMemoizedSerializedSize = iComputeInt32SizeNoTag2;
        for (int i6 = 0; i6 < this.constructor_.size(); i6++) {
            iComputeMessageSize2 += CodedOutputStream.computeMessageSize(8, this.constructor_.get(i6));
        }
        for (int i7 = 0; i7 < this.function_.size(); i7++) {
            iComputeMessageSize2 += CodedOutputStream.computeMessageSize(9, this.function_.get(i7));
        }
        for (int i8 = 0; i8 < this.property_.size(); i8++) {
            iComputeMessageSize2 += CodedOutputStream.computeMessageSize(10, this.property_.get(i8));
        }
        for (int i9 = 0; i9 < this.typeAlias_.size(); i9++) {
            iComputeMessageSize2 += CodedOutputStream.computeMessageSize(11, this.typeAlias_.get(i9));
        }
        for (int i10 = 0; i10 < this.enumEntry_.size(); i10++) {
            iComputeMessageSize2 += CodedOutputStream.computeMessageSize(13, this.enumEntry_.get(i10));
        }
        int iComputeInt32SizeNoTag3 = 0;
        for (int i11 = 0; i11 < this.sealedSubclassFqName_.size(); i11++) {
            iComputeInt32SizeNoTag3 += CodedOutputStream.computeInt32SizeNoTag(this.sealedSubclassFqName_.get(i11).intValue());
        }
        int iComputeMessageSize3 = iComputeMessageSize2 + iComputeInt32SizeNoTag3;
        if (!getSealedSubclassFqNameList().isEmpty()) {
            iComputeMessageSize3 = iComputeMessageSize3 + 2 + CodedOutputStream.computeInt32SizeNoTag(iComputeInt32SizeNoTag3);
        }
        this.sealedSubclassFqNameMemoizedSerializedSize = iComputeInt32SizeNoTag3;
        if ((this.bitField0_ & 8) == 8) {
            iComputeMessageSize3 += CodedOutputStream.computeMessageSize(30, this.typeTable_);
        }
        int iComputeInt32SizeNoTag4 = 0;
        for (int i12 = 0; i12 < this.versionRequirement_.size(); i12++) {
            iComputeInt32SizeNoTag4 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i12).intValue());
        }
        int size = (getVersionRequirementList().size() * 2) + iComputeMessageSize3 + iComputeInt32SizeNoTag4;
        if ((this.bitField0_ & 16) == 16) {
            size += CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
        }
        int size2 = this.unknownFields.size() + c() + size;
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public q getSupertype(int i) {
        return this.supertype_.get(i);
    }

    public int getSupertypeCount() {
        return this.supertype_.size();
    }

    public List<Integer> getSupertypeIdList() {
        return this.supertypeId_;
    }

    public List<q> getSupertypeList() {
        return this.supertype_;
    }

    public r getTypeAlias(int i) {
        return this.typeAlias_.get(i);
    }

    public int getTypeAliasCount() {
        return this.typeAlias_.size();
    }

    public List<r> getTypeAliasList() {
        return this.typeAlias_;
    }

    public s getTypeParameter(int i) {
        return this.typeParameter_.get(i);
    }

    public int getTypeParameterCount() {
        return this.typeParameter_.size();
    }

    public List<s> getTypeParameterList() {
        return this.typeParameter_;
    }

    public t getTypeTable() {
        return this.typeTable_;
    }

    public List<Integer> getVersionRequirementList() {
        return this.versionRequirement_;
    }

    public w getVersionRequirementTable() {
        return this.versionRequirementTable_;
    }

    public boolean hasCompanionObjectName() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasFqName() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasTypeTable() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasVersionRequirementTable() {
        return (this.bitField0_ & 16) == 16;
    }

    @Override // d0.e0.p.d.m0.i.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.memoizedIsInitialized;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        if (!hasFqName()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i = 0; i < getTypeParameterCount(); i++) {
            if (!getTypeParameter(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i2 = 0; i2 < getSupertypeCount(); i2++) {
            if (!getSupertype(i2).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i3 = 0; i3 < getConstructorCount(); i3++) {
            if (!getConstructor(i3).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i4 = 0; i4 < getFunctionCount(); i4++) {
            if (!getFunction(i4).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i5 = 0; i5 < getPropertyCount(); i5++) {
            if (!getProperty(i5).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i6 = 0; i6 < getTypeAliasCount(); i6++) {
            if (!getTypeAlias(i6).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i7 = 0; i7 < getEnumEntryCount(); i7++) {
            if (!getEnumEntry(i7).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (hasTypeTable() && !getTypeTable().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (b()) {
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }
        this.memoizedIsInitialized = (byte) 0;
        return false;
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.d<MessageType>.a aVarE = e();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(1, this.flags_);
        }
        if (getSupertypeIdList().size() > 0) {
            codedOutputStream.writeRawVarint32(18);
            codedOutputStream.writeRawVarint32(this.supertypeIdMemoizedSerializedSize);
        }
        for (int i = 0; i < this.supertypeId_.size(); i++) {
            codedOutputStream.writeInt32NoTag(this.supertypeId_.get(i).intValue());
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(3, this.fqName_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeInt32(4, this.companionObjectName_);
        }
        for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
            codedOutputStream.writeMessage(5, this.typeParameter_.get(i2));
        }
        for (int i3 = 0; i3 < this.supertype_.size(); i3++) {
            codedOutputStream.writeMessage(6, this.supertype_.get(i3));
        }
        if (getNestedClassNameList().size() > 0) {
            codedOutputStream.writeRawVarint32(58);
            codedOutputStream.writeRawVarint32(this.nestedClassNameMemoizedSerializedSize);
        }
        for (int i4 = 0; i4 < this.nestedClassName_.size(); i4++) {
            codedOutputStream.writeInt32NoTag(this.nestedClassName_.get(i4).intValue());
        }
        for (int i5 = 0; i5 < this.constructor_.size(); i5++) {
            codedOutputStream.writeMessage(8, this.constructor_.get(i5));
        }
        for (int i6 = 0; i6 < this.function_.size(); i6++) {
            codedOutputStream.writeMessage(9, this.function_.get(i6));
        }
        for (int i7 = 0; i7 < this.property_.size(); i7++) {
            codedOutputStream.writeMessage(10, this.property_.get(i7));
        }
        for (int i8 = 0; i8 < this.typeAlias_.size(); i8++) {
            codedOutputStream.writeMessage(11, this.typeAlias_.get(i8));
        }
        for (int i9 = 0; i9 < this.enumEntry_.size(); i9++) {
            codedOutputStream.writeMessage(13, this.enumEntry_.get(i9));
        }
        if (getSealedSubclassFqNameList().size() > 0) {
            codedOutputStream.writeRawVarint32(130);
            codedOutputStream.writeRawVarint32(this.sealedSubclassFqNameMemoizedSerializedSize);
        }
        for (int i10 = 0; i10 < this.sealedSubclassFqName_.size(); i10++) {
            codedOutputStream.writeInt32NoTag(this.sealedSubclassFqName_.get(i10).intValue());
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeMessage(30, this.typeTable_);
        }
        for (int i11 = 0; i11 < this.versionRequirement_.size(); i11++) {
            codedOutputStream.writeInt32(31, this.versionRequirement_.get(i11).intValue());
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeMessage(32, this.versionRequirementTable_);
        }
        aVarE.writeUntil(19000, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static b newBuilder() {
        return new b();
    }

    @Override // d0.e0.p.d.m0.i.MessageLiteOrBuilder
    public c getDefaultInstanceForType() {
        return j;
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public b newBuilderForType() {
        return newBuilder();
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public b toBuilder() {
        return newBuilder(this);
    }

    public c() {
        this.supertypeIdMemoizedSerializedSize = -1;
        this.nestedClassNameMemoizedSerializedSize = -1;
        this.sealedSubclassFqNameMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString3.j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this.supertypeIdMemoizedSerializedSize = -1;
        this.nestedClassNameMemoizedSerializedSize = -1;
        this.sealedSubclassFqNameMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        K();
        ByteString3.b bVarNewOutput = ByteString3.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
        int i = 0;
        while (!z2) {
            try {
                try {
                    int tag = codedInputStream.readTag();
                    switch (tag) {
                        case 0:
                            z2 = true;
                            break;
                        case 8:
                            this.bitField0_ |= 1;
                            this.flags_ = codedInputStream.readInt32();
                            break;
                        case 16:
                            if ((i & 32) != 32) {
                                this.supertypeId_ = new ArrayList();
                                i |= 32;
                            }
                            this.supertypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 18:
                            int iPushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if ((i & 32) != 32 && codedInputStream.getBytesUntilLimit() > 0) {
                                this.supertypeId_ = new ArrayList();
                                i |= 32;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.supertypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(iPushLimit);
                            break;
                        case 24:
                            this.bitField0_ |= 2;
                            this.fqName_ = codedInputStream.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 4;
                            this.companionObjectName_ = codedInputStream.readInt32();
                            break;
                        case 42:
                            if ((i & 8) != 8) {
                                this.typeParameter_ = new ArrayList();
                                i |= 8;
                            }
                            this.typeParameter_.add((s) codedInputStream.readMessage(s.k, extensionRegistryLite));
                            break;
                        case 50:
                            if ((i & 16) != 16) {
                                this.supertype_ = new ArrayList();
                                i |= 16;
                            }
                            this.supertype_.add((q) codedInputStream.readMessage(q.k, extensionRegistryLite));
                            break;
                        case 56:
                            if ((i & 64) != 64) {
                                this.nestedClassName_ = new ArrayList();
                                i |= 64;
                            }
                            this.nestedClassName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 58:
                            int iPushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if ((i & 64) != 64 && codedInputStream.getBytesUntilLimit() > 0) {
                                this.nestedClassName_ = new ArrayList();
                                i |= 64;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.nestedClassName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(iPushLimit2);
                            break;
                        case 66:
                            if ((i & 128) != 128) {
                                this.constructor_ = new ArrayList();
                                i |= 128;
                            }
                            this.constructor_.add((d) codedInputStream.readMessage(d.k, extensionRegistryLite));
                            break;
                        case 74:
                            if ((i & 256) != 256) {
                                this.function_ = new ArrayList();
                                i |= 256;
                            }
                            this.function_.add((i) codedInputStream.readMessage(i.k, extensionRegistryLite));
                            break;
                        case 82:
                            if ((i & 512) != 512) {
                                this.property_ = new ArrayList();
                                i |= 512;
                            }
                            this.property_.add((n) codedInputStream.readMessage(n.k, extensionRegistryLite));
                            break;
                        case 90:
                            if ((i & 1024) != 1024) {
                                this.typeAlias_ = new ArrayList();
                                i |= 1024;
                            }
                            this.typeAlias_.add((r) codedInputStream.readMessage(r.k, extensionRegistryLite));
                            break;
                        case 106:
                            if ((i & 2048) != 2048) {
                                this.enumEntry_ = new ArrayList();
                                i |= 2048;
                            }
                            this.enumEntry_.add((g) codedInputStream.readMessage(g.k, extensionRegistryLite));
                            break;
                        case 128:
                            if ((i & 4096) != 4096) {
                                this.sealedSubclassFqName_ = new ArrayList();
                                i |= 4096;
                            }
                            this.sealedSubclassFqName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 130:
                            int iPushLimit3 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if ((i & 4096) != 4096 && codedInputStream.getBytesUntilLimit() > 0) {
                                this.sealedSubclassFqName_ = new ArrayList();
                                i |= 4096;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.sealedSubclassFqName_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(iPushLimit3);
                            break;
                        case 242:
                            t.b builder = (this.bitField0_ & 8) == 8 ? this.typeTable_.toBuilder() : null;
                            t tVar = (t) codedInputStream.readMessage(t.k, extensionRegistryLite);
                            this.typeTable_ = tVar;
                            if (builder != 0) {
                                builder.mergeFrom(tVar);
                                this.typeTable_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 8;
                            break;
                        case 248:
                            if ((i & 16384) != 16384) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 16384;
                            }
                            this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                            break;
                        case 250:
                            int iPushLimit4 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if ((i & 16384) != 16384 && codedInputStream.getBytesUntilLimit() > 0) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 16384;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(iPushLimit4);
                            break;
                        case 258:
                            w.b builder2 = (this.bitField0_ & 16) == 16 ? this.versionRequirementTable_.toBuilder() : null;
                            w wVar = (w) codedInputStream.readMessage(w.k, extensionRegistryLite);
                            this.versionRequirementTable_ = wVar;
                            if (builder2 != 0) {
                                builder2.mergeFrom(wVar);
                                this.versionRequirementTable_ = builder2.buildPartial();
                            }
                            this.bitField0_ |= 16;
                            break;
                        default:
                            if (!f(codedInputStream, codedOutputStreamNewInstance, extensionRegistryLite, tag)) {
                                z2 = true;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if ((i & 32) == 32) {
                    this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                }
                if ((i & 8) == 8) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                }
                if ((i & 16) == 16) {
                    this.supertype_ = Collections.unmodifiableList(this.supertype_);
                }
                if ((i & 64) == 64) {
                    this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                }
                if ((i & 128) == 128) {
                    this.constructor_ = Collections.unmodifiableList(this.constructor_);
                }
                if ((i & 256) == 256) {
                    this.function_ = Collections.unmodifiableList(this.function_);
                }
                if ((i & 512) == 512) {
                    this.property_ = Collections.unmodifiableList(this.property_);
                }
                if ((i & 1024) == 1024) {
                    this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                }
                if ((i & 2048) == 2048) {
                    this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                }
                if ((i & 4096) == 4096) {
                    this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
                }
                if ((i & 16384) == 16384) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                }
                try {
                    codedOutputStreamNewInstance.flush();
                } catch (IOException unused) {
                } finally {
                    this.unknownFields = bVarNewOutput.toByteString();
                }
                d();
                throw th;
            }
        }
        if ((i & 32) == 32) {
            this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
        }
        if ((i & 8) == 8) {
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        }
        if ((i & 16) == 16) {
            this.supertype_ = Collections.unmodifiableList(this.supertype_);
        }
        if ((i & 64) == 64) {
            this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
        }
        if ((i & 128) == 128) {
            this.constructor_ = Collections.unmodifiableList(this.constructor_);
        }
        if ((i & 256) == 256) {
            this.function_ = Collections.unmodifiableList(this.function_);
        }
        if ((i & 512) == 512) {
            this.property_ = Collections.unmodifiableList(this.property_);
        }
        if ((i & 1024) == 1024) {
            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
        }
        if ((i & 2048) == 2048) {
            this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
        }
        if ((i & 4096) == 4096) {
            this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
        }
        if ((i & 16384) == 16384) {
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        }
        try {
            codedOutputStreamNewInstance.flush();
        } catch (IOException unused2) {
        } finally {
            this.unknownFields = bVarNewOutput.toByteString();
        }
        d();
    }
}
