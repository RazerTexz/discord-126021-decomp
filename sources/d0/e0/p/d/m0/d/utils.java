package d0.e0.p.d.m0.d;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.PackageFragmentDescriptor;
import d0.e0.p.d.m0.d.b.LookupLocation;
import d0.e0.p.d.m0.d.b.LookupLocation2;
import d0.e0.p.d.m0.d.b.LookupLocation4;
import d0.e0.p.d.m0.d.b.LookupTracker;
import d0.e0.p.d.m0.d.b.LookupTracker2;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.DescriptorUtils;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.d.a, reason: use source file name */
/* JADX INFO: compiled from: utils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class utils {
    public static final void record(LookupTracker lookupTracker, LookupLocation2 lookupLocation2, ClassDescriptor classDescriptor, Name name) {
        LookupLocation location;
        Intrinsics3.checkNotNullParameter(lookupTracker, "<this>");
        Intrinsics3.checkNotNullParameter(lookupLocation2, "from");
        Intrinsics3.checkNotNullParameter(classDescriptor, "scopeOwner");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (lookupTracker == LookupTracker.a.a || (location = lookupLocation2.getLocation()) == null) {
            return;
        }
        LookupLocation4 position = lookupTracker.getRequiresPosition() ? location.getPosition() : LookupLocation4.j.getNO_POSITION();
        String filePath = location.getFilePath();
        String strAsString = DescriptorUtils.getFqName(classDescriptor).asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "getFqName(scopeOwner).asString()");
        LookupTracker2 lookupTracker2 = LookupTracker2.CLASSIFIER;
        String strAsString2 = name.asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString2, "name.asString()");
        lookupTracker.record(filePath, position, strAsString, lookupTracker2, strAsString2);
    }

    public static final void recordPackageLookup(LookupTracker lookupTracker, LookupLocation2 lookupLocation2, String str, String str2) {
        LookupLocation location;
        Intrinsics3.checkNotNullParameter(lookupTracker, "<this>");
        Intrinsics3.checkNotNullParameter(lookupLocation2, "from");
        Intrinsics3.checkNotNullParameter(str, "packageFqName");
        Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (lookupTracker == LookupTracker.a.a || (location = lookupLocation2.getLocation()) == null) {
            return;
        }
        lookupTracker.record(location.getFilePath(), lookupTracker.getRequiresPosition() ? location.getPosition() : LookupLocation4.j.getNO_POSITION(), str, LookupTracker2.PACKAGE, str2);
    }

    public static final void record(LookupTracker lookupTracker, LookupLocation2 lookupLocation2, PackageFragmentDescriptor packageFragmentDescriptor, Name name) {
        Intrinsics3.checkNotNullParameter(lookupTracker, "<this>");
        Intrinsics3.checkNotNullParameter(lookupLocation2, "from");
        Intrinsics3.checkNotNullParameter(packageFragmentDescriptor, "scopeOwner");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        String strAsString = packageFragmentDescriptor.getFqName().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "scopeOwner.fqName.asString()");
        String strAsString2 = name.asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString2, "name.asString()");
        recordPackageLookup(lookupTracker, lookupLocation2, strAsString, strAsString2);
    }
}
