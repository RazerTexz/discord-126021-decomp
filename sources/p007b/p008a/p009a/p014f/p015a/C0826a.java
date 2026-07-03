package p007b.p008a.p009a.p014f.p015a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.radiobutton.MaterialRadioButton;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p000.C12788k;
import p007b.p008a.p009a.p014f.p015a.C0829d;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p025i.C0919b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: renamed from: b.a.a.f.a.a */
/* JADX INFO: compiled from: AudioOutputSelectionDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0826a extends AppDialog {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f352j = {C1643a.m846d0(C0826a.class, "binding", "getBinding()Lcom/discord/databinding/AudioOutputSelectionDialogBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final Lazy viewModel;

    /* JADX INFO: renamed from: b.a.a.f.a.a$a */
    /* JADX INFO: compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ int f356j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Object f357k;

        public a(int i, Object obj) {
            this.f356j = i;
            this.f357k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.f356j;
            if (i == 0) {
                C0826a.m130h((C0826a) this.f357k).f360j.selectOutputDevice(DiscordAudioManager.DeviceTypes.BLUETOOTH_HEADSET);
                C0826a.m129g((C0826a) this.f357k);
                return;
            }
            if (i == 1) {
                C0826a.m130h((C0826a) this.f357k).f360j.selectOutputDevice(DiscordAudioManager.DeviceTypes.SPEAKERPHONE);
                C0826a.m129g((C0826a) this.f357k);
            } else if (i == 2) {
                C0826a.m130h((C0826a) this.f357k).f360j.selectOutputDevice(DiscordAudioManager.DeviceTypes.WIRED_HEADSET);
                C0826a.m129g((C0826a) this.f357k);
            } else {
                if (i != 3) {
                    throw null;
                }
                C0826a.m130h((C0826a) this.f357k).f360j.selectOutputDevice(DiscordAudioManager.DeviceTypes.EARPIECE);
                C0826a.m129g((C0826a) this.f357k);
            }
        }
    }

    /* JADX INFO: renamed from: b.a.a.f.a.a$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: AudioOutputSelectionDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.a.f.a.a$c */
    /* JADX INFO: compiled from: AudioOutputSelectionDialog.kt */
    public static final /* synthetic */ class c extends C12236k implements Function1<View, C0919b> {

        /* JADX INFO: renamed from: j */
        public static final c f358j = new c();

        public c() {
            super(1, C0919b.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/AudioOutputSelectionDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public C0919b invoke(View view) {
            View view2 = view;
            C12238m.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.audio_output_selection_bluetooth_radio;
            MaterialRadioButton materialRadioButton = (MaterialRadioButton) view2.findViewById(C5419R.id.audio_output_selection_bluetooth_radio);
            if (materialRadioButton != null) {
                i = C5419R.id.audio_output_selection_dialog_header;
                TextView textView = (TextView) view2.findViewById(C5419R.id.audio_output_selection_dialog_header);
                if (textView != null) {
                    i = C5419R.id.audio_output_selection_dialog_radio_group;
                    RadioGroup radioGroup = (RadioGroup) view2.findViewById(C5419R.id.audio_output_selection_dialog_radio_group);
                    if (radioGroup != null) {
                        i = C5419R.id.audio_output_selection_earpiece_radio;
                        MaterialRadioButton materialRadioButton2 = (MaterialRadioButton) view2.findViewById(C5419R.id.audio_output_selection_earpiece_radio);
                        if (materialRadioButton2 != null) {
                            i = C5419R.id.audio_output_selection_speaker_radio;
                            MaterialRadioButton materialRadioButton3 = (MaterialRadioButton) view2.findViewById(C5419R.id.audio_output_selection_speaker_radio);
                            if (materialRadioButton3 != null) {
                                i = C5419R.id.audio_output_selection_wired_radio;
                                MaterialRadioButton materialRadioButton4 = (MaterialRadioButton) view2.findViewById(C5419R.id.audio_output_selection_wired_radio);
                                if (materialRadioButton4 != null) {
                                    return new C0919b((LinearLayout) view2, materialRadioButton, textView, radioGroup, materialRadioButton2, materialRadioButton3, materialRadioButton4);
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: b.a.a.f.a.a$d */
    /* JADX INFO: compiled from: AudioOutputSelectionDialog.kt */
    public static final class d extends AbstractC12240o implements Function1<C0829d.a, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(C0829d.a aVar) {
            int id2;
            C0829d.a aVar2 = aVar;
            C12238m.checkNotNullParameter(aVar2, "viewState");
            C0826a c0826a = C0826a.this;
            Objects.requireNonNull(c0826a);
            C12238m.checkNotNullParameter(aVar2, "viewState");
            if (!(aVar2 instanceof C0829d.a.b) && (aVar2 instanceof C0829d.a.C13208a)) {
                C0829d.a.C13208a c13208a = (C0829d.a.C13208a) aVar2;
                int iOrdinal = c13208a.f361a.ordinal();
                if (iOrdinal == 2) {
                    MaterialRadioButton materialRadioButton = c0826a.m131i().f689e;
                    C12238m.checkNotNullExpressionValue(materialRadioButton, "binding.audioOutputSelectionSpeakerRadio");
                    id2 = materialRadioButton.getId();
                } else if (iOrdinal == 3) {
                    MaterialRadioButton materialRadioButton2 = c0826a.m131i().f690f;
                    C12238m.checkNotNullExpressionValue(materialRadioButton2, "binding.audioOutputSelectionWiredRadio");
                    id2 = materialRadioButton2.getId();
                } else if (iOrdinal == 4) {
                    MaterialRadioButton materialRadioButton3 = c0826a.m131i().f688d;
                    C12238m.checkNotNullExpressionValue(materialRadioButton3, "binding.audioOutputSelectionEarpieceRadio");
                    id2 = materialRadioButton3.getId();
                } else if (iOrdinal == 5) {
                    MaterialRadioButton materialRadioButton4 = c0826a.m131i().f686b;
                    C12238m.checkNotNullExpressionValue(materialRadioButton4, "binding.audioOutputSelectionBluetoothRadio");
                    id2 = materialRadioButton4.getId();
                }
                c0826a.m131i().f687c.check(id2);
                MaterialRadioButton materialRadioButton5 = c0826a.m131i().f686b;
                C12238m.checkNotNullExpressionValue(materialRadioButton5, "binding.audioOutputSelectionBluetoothRadio");
                materialRadioButton5.setVisibility(c13208a.f362b ? 0 : 8);
                MaterialRadioButton materialRadioButton6 = c0826a.m131i().f686b;
                C12238m.checkNotNullExpressionValue(materialRadioButton6, "binding.audioOutputSelectionBluetoothRadio");
                String string = c13208a.f363c;
                if (string == null) {
                    string = c0826a.getString(C5419R.string.audio_devices_bluetooth);
                }
                materialRadioButton6.setText(string);
                MaterialRadioButton materialRadioButton7 = c0826a.m131i().f689e;
                C12238m.checkNotNullExpressionValue(materialRadioButton7, "binding.audioOutputSelectionSpeakerRadio");
                materialRadioButton7.setVisibility(c13208a.f364d ? 0 : 8);
                MaterialRadioButton materialRadioButton8 = c0826a.m131i().f690f;
                C12238m.checkNotNullExpressionValue(materialRadioButton8, "binding.audioOutputSelectionWiredRadio");
                materialRadioButton8.setVisibility(c13208a.f365e ? 0 : 8);
                MaterialRadioButton materialRadioButton9 = c0826a.m131i().f688d;
                C12238m.checkNotNullExpressionValue(materialRadioButton9, "binding.audioOutputSelectionEarpieceRadio");
                materialRadioButton9.setVisibility(c13208a.f366f ? 0 : 8);
            }
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.a.f.a.a$e */
    /* JADX INFO: compiled from: AudioOutputSelectionDialog.kt */
    public static final class e extends AbstractC12240o implements Function0<C0829d> {

        /* JADX INFO: renamed from: j */
        public static final e f359j = new e();

        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public C0829d invoke() {
            return new C0829d(null, null, 3);
        }
    }

    public C0826a() {
        super(C5419R.layout.audio_output_selection_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, c.f358j, null, 2, null);
        e eVar = e.f359j;
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(C0829d.class), new C12788k(5, c0865g0), new C0869i0(eVar));
    }

    /* JADX INFO: renamed from: g */
    public static final void m129g(C0826a c0826a) {
        Objects.requireNonNull(c0826a);
        Observable<Long> observableM11068d0 = Observable.m11068d0(300L, TimeUnit.MILLISECONDS);
        C12238m.checkNotNullExpressionValue(observableM11068d0, "Observable\n        .time…S, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11068d0, c0826a, null, 2, null), (Class<?>) C0826a.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C0827b(c0826a));
    }

    /* JADX INFO: renamed from: h */
    public static final C0829d m130h(C0826a c0826a) {
        return (C0829d) c0826a.viewModel.getValue();
    }

    /* JADX INFO: renamed from: i */
    public final C0919b m131i() {
        return (C0919b) this.binding.getValue((Fragment) this, f352j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        int themedColor = ColorCompat.getThemedColor(view, C5419R.attr.colorInteractiveNormal);
        MaterialRadioButton materialRadioButton = m131i().f686b;
        C12238m.checkNotNullExpressionValue(materialRadioButton, "binding.audioOutputSelectionBluetoothRadio");
        ColorCompatKt.setDrawableColor(materialRadioButton, themedColor);
        MaterialRadioButton materialRadioButton2 = m131i().f689e;
        C12238m.checkNotNullExpressionValue(materialRadioButton2, "binding.audioOutputSelectionSpeakerRadio");
        ColorCompatKt.setDrawableColor(materialRadioButton2, themedColor);
        MaterialRadioButton materialRadioButton3 = m131i().f690f;
        C12238m.checkNotNullExpressionValue(materialRadioButton3, "binding.audioOutputSelectionWiredRadio");
        ColorCompatKt.setDrawableColor(materialRadioButton3, themedColor);
        MaterialRadioButton materialRadioButton4 = m131i().f688d;
        C12238m.checkNotNullExpressionValue(materialRadioButton4, "binding.audioOutputSelectionEarpieceRadio");
        ColorCompatKt.setDrawableColor(materialRadioButton4, themedColor);
        m131i().f686b.setOnClickListener(new a(0, this));
        m131i().f689e.setOnClickListener(new a(1, this));
        m131i().f690f.setOnClickListener(new a(2, this));
        m131i().f688d.setOnClickListener(new a(3, this));
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(((C0829d) this.viewModel.getValue()).observeViewState(), this, null, 2, null), (Class<?>) C0826a.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new d());
    }
}
