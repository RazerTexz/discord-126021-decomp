package com.discord.widgets.phone;

import android.content.Context;
import android.text.Editable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetPhoneCountryCodeBottomSheetBinding;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.stores.StorePhone;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.phone.PhoneUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetPhoneCountryCodeBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPhoneCountryCodeBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetPhoneCountryCodeBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetPhoneCountryCodeBottomSheetBinding;", 0)};

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
            Intrinsics3.checkNotNullParameter(context, "context");
            new WidgetPhoneCountryCodeBottomSheet().show(context, WidgetPhoneCountryCodeBottomSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.phone.WidgetPhoneCountryCodeBottomSheet$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetPhoneCountryCodeBottomSheet.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            WidgetPhoneCountryCodeBottomSheet.this.nameFilterSubject.onNext(editable.toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.phone.WidgetPhoneCountryCodeBottomSheet$onResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetPhoneCountryCodeBottomSheet.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            WidgetPhoneCountryCodeBottomSheet widgetPhoneCountryCodeBottomSheet = WidgetPhoneCountryCodeBottomSheet.this;
            Intrinsics3.checkNotNullExpressionValue(str, "it");
            widgetPhoneCountryCodeBottomSheet.configureUI(str);
        }
    }

    public WidgetPhoneCountryCodeBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetPhoneCountryCodeBottomSheet2.INSTANCE, null, 2, null);
        BehaviorSubject<String> behaviorSubjectL0 = BehaviorSubject.l0("");
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(\"\")");
        this.nameFilterSubject = behaviorSubjectL0;
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
                getBinding().f2509b.setHasFixedSize(false);
                RecyclerView recyclerView = getBinding().f2509b;
                Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.phoneCountryCodeRecycler");
                recyclerView.setAdapter(this.adapter);
                this.adapter.configure(arrayList, new PhoneCountryCodeAdapter2() { // from class: com.discord.widgets.phone.WidgetPhoneCountryCodeBottomSheet.configureUI.1
                    @Override // com.discord.widgets.phone.PhoneCountryCodeAdapter2
                    public final void onCountryCodeSelected(PhoneCountryCode phoneCountryCode) {
                        Intrinsics3.checkNotNullParameter(phoneCountryCode, "it");
                        phone.updateSelectedCountryCode(phoneCountryCode);
                        WidgetPhoneCountryCodeBottomSheet.this.dismiss();
                    }
                });
                return;
            }
            Object next = it.next();
            PhoneCountryCode phoneCountryCode = (PhoneCountryCode) next;
            if (!Strings4.contains((CharSequence) phoneCountryCode.getName(), (CharSequence) filter, true)) {
                PhoneUtils phoneUtils = PhoneUtils.INSTANCE;
                Context contextRequireContext = requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                z2 = Strings4.contains((CharSequence) phoneUtils.getTranslatedStringForCountry(phoneCountryCode, contextRequireContext), (CharSequence) filter, true);
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
        return R.layout.widget_phone_country_code_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.phoneCountryCodeSearch");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass1());
        Observable<String> observableP = this.nameFilterSubject.p(200L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableP, "nameFilterSubject.deboun…0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableP, this, null, 2, null), (Class<?>) WidgetPhoneCountryCodeBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
        configureUI("");
    }
}
