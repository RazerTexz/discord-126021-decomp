package com.discord.widgets.phone;

import android.content.Context;
import android.text.Editable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetPhoneCountryCodeBottomSheetBinding;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.stores.StorePhone;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.phone.PhoneUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetPhoneCountryCodeBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPhoneCountryCodeBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetPhoneCountryCodeBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetPhoneCountryCodeBottomSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PhoneCountryCodeAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final BehaviorSubject<String> nameFilterSubject;

    /* JADX INFO: compiled from: WidgetPhoneCountryCodeBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager context) {
            C12238m.checkNotNullParameter(context, "context");
            new WidgetPhoneCountryCodeBottomSheet().show(context, WidgetPhoneCountryCodeBottomSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.phone.WidgetPhoneCountryCodeBottomSheet$onResume$1 */
    /* JADX INFO: compiled from: WidgetPhoneCountryCodeBottomSheet.kt */
    public static final class C91171 extends AbstractC12240o implements Function1<Editable, Unit> {
        public C91171() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            C12238m.checkNotNullParameter(editable, "it");
            WidgetPhoneCountryCodeBottomSheet.this.nameFilterSubject.onNext(editable.toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.phone.WidgetPhoneCountryCodeBottomSheet$onResume$2 */
    /* JADX INFO: compiled from: WidgetPhoneCountryCodeBottomSheet.kt */
    public static final class C91182 extends AbstractC12240o implements Function1<String, Unit> {
        public C91182() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            WidgetPhoneCountryCodeBottomSheet widgetPhoneCountryCodeBottomSheet = WidgetPhoneCountryCodeBottomSheet.this;
            C12238m.checkNotNullExpressionValue(str, "it");
            widgetPhoneCountryCodeBottomSheet.configureUI(str);
        }
    }

    public WidgetPhoneCountryCodeBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetPhoneCountryCodeBottomSheet$binding$2.INSTANCE, null, 2, null);
        BehaviorSubject<String> behaviorSubjectM11130l0 = BehaviorSubject.m11130l0("");
        C12238m.checkNotNullExpressionValue(behaviorSubjectM11130l0, "BehaviorSubject.create(\"\")");
        this.nameFilterSubject = behaviorSubjectM11130l0;
        this.adapter = new PhoneCountryCodeAdapter();
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0041  */
    private final void configureUI(String filter) {
        boolean z2;
        final StorePhone phone = StoreStream.INSTANCE.getPhone();
        List<PhoneCountryCode> countryCodes = phone.getCountryCodes();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = countryCodes.iterator();
        while (true) {
            if (!it.hasNext()) {
                getBinding().f17364b.setHasFixedSize(false);
                RecyclerView recyclerView = getBinding().f17364b;
                C12238m.checkNotNullExpressionValue(recyclerView, "binding.phoneCountryCodeRecycler");
                recyclerView.setAdapter(this.adapter);
                this.adapter.configure(arrayList, new OnCountryCodeSelectedListener() { // from class: com.discord.widgets.phone.WidgetPhoneCountryCodeBottomSheet.configureUI.1
                    @Override // com.discord.widgets.phone.OnCountryCodeSelectedListener
                    public final void onCountryCodeSelected(PhoneCountryCode phoneCountryCode) {
                        C12238m.checkNotNullParameter(phoneCountryCode, "it");
                        phone.updateSelectedCountryCode(phoneCountryCode);
                        WidgetPhoneCountryCodeBottomSheet.this.dismiss();
                    }
                });
                return;
            }
            Object next = it.next();
            PhoneCountryCode phoneCountryCode = (PhoneCountryCode) next;
            if (!C12106w.contains((CharSequence) phoneCountryCode.getName(), (CharSequence) filter, true)) {
                PhoneUtils phoneUtils = PhoneUtils.INSTANCE;
                Context contextRequireContext = requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                z2 = C12106w.contains((CharSequence) phoneUtils.getTranslatedStringForCountry(phoneCountryCode, contextRequireContext), (CharSequence) filter, true);
            }
            if (z2) {
                arrayList.add(next);
            }
        }
    }

    private final WidgetPhoneCountryCodeBottomSheetBinding getBinding() {
        return (WidgetPhoneCountryCodeBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_phone_country_code_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        TextInputLayout textInputLayout = getBinding().f17365c;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.phoneCountryCodeSearch");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C91171());
        Observable<String> observableM11110p = this.nameFilterSubject.m11110p(200L, TimeUnit.MILLISECONDS);
        C12238m.checkNotNullExpressionValue(observableM11110p, "nameFilterSubject.deboun…0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11110p, this, null, 2, null), (Class<?>) WidgetPhoneCountryCodeBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C91182());
        configureUI("");
    }
}
