package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.k.a0.p.ReceiverValue;
import d0.e0.p.d.m0.n.TypeSubstitutor2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.q0, reason: use source file name */
/* JADX INFO: compiled from: ReceiverParameterDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public interface ReceiverParameterDescriptor extends ParameterDescriptor {
    ReceiverValue getValue();

    ReceiverParameterDescriptor substitute(TypeSubstitutor2 typeSubstitutor2);
}
