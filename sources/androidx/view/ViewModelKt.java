package androidx.view;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.C13116h1;
import p659s.p660a.C13124k0;
import p659s.p660a.p661a.C13031n;

/* JADX INFO: compiled from: ViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewModelKt {
    private static final String JOB_KEY = "androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY";

    public static final CoroutineScope getViewModelScope(ViewModel viewModel) {
        C12238m.checkNotNullParameter(viewModel, "$this$viewModelScope");
        CoroutineScope coroutineScope = (CoroutineScope) viewModel.getTag(JOB_KEY);
        if (coroutineScope != null) {
            return coroutineScope;
        }
        Job jobM4279d = C3404f.m4279d(null, 1);
        CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
        Object tagIfAbsent = viewModel.setTagIfAbsent(JOB_KEY, new CloseableCoroutineScope(CoroutineContext.Element.C12790a.plus((C13116h1) jobM4279d, C13031n.f27700b.mo11194H())));
        C12238m.checkNotNullExpressionValue(tagIfAbsent, "setTagIfAbsent(\n        …Main.immediate)\n        )");
        return (CoroutineScope) tagIfAbsent;
    }
}
