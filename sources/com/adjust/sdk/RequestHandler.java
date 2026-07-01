package com.adjust.sdk;

import b.d.b.a.outline;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadExecutor;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.SocketTimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class RequestHandler implements IRequestHandler {
    private WeakReference<IActivityHandler> activityHandlerWeakRef;
    private String basePath;
    private String gdprPath;
    private WeakReference<IPackageHandler> packageHandlerWeakRef;
    private String subscriptionPath;
    private ILogger logger = AdjustFactory.getLogger();
    private ThreadExecutor executor = new SingleThreadCachedScheduler("RequestHandler");

    public RequestHandler(IActivityHandler iActivityHandler, IPackageHandler iPackageHandler) {
        init(iActivityHandler, iPackageHandler);
        this.basePath = iPackageHandler.getBasePath();
        this.gdprPath = iPackageHandler.getGdprPath();
        this.subscriptionPath = iPackageHandler.getSubscriptionPath();
    }

    private void closePackageI(ActivityPackage activityPackage, String str, Throwable th) {
        String string = Util.formatString("%s. (%s) Will retry later", activityPackage.getFailureMessage(), Util.getReasonString(str, th));
        this.logger.error(string, new Object[0]);
        ResponseData responseDataBuildResponseData = ResponseData.buildResponseData(activityPackage);
        responseDataBuildResponseData.message = string;
        IPackageHandler iPackageHandler = this.packageHandlerWeakRef.get();
        if (iPackageHandler == null) {
            return;
        }
        iPackageHandler.closeFirstPackage(responseDataBuildResponseData, activityPackage);
    }

    private void sendI(ActivityPackage activityPackage, int i) {
        String baseUrl;
        IActivityHandler iActivityHandler;
        if (activityPackage.getActivityKind() == ActivityKind.GDPR) {
            baseUrl = AdjustFactory.getGdprUrl();
            if (this.gdprPath != null) {
                StringBuilder sbU = outline.U(baseUrl);
                sbU.append(this.gdprPath);
                baseUrl = sbU.toString();
            }
        } else if (activityPackage.getActivityKind() == ActivityKind.SUBSCRIPTION) {
            baseUrl = AdjustFactory.getSubscriptionUrl();
            if (this.subscriptionPath != null) {
                StringBuilder sbU2 = outline.U(baseUrl);
                sbU2.append(this.subscriptionPath);
                baseUrl = sbU2.toString();
            }
        } else {
            baseUrl = AdjustFactory.getBaseUrl();
            if (this.basePath != null) {
                StringBuilder sbU3 = outline.U(baseUrl);
                sbU3.append(this.basePath);
                baseUrl = sbU3.toString();
            }
        }
        StringBuilder sbU4 = outline.U(baseUrl);
        sbU4.append(activityPackage.getPath());
        try {
            ResponseData responseDataCreatePOSTHttpsURLConnection = UtilNetworking.createPOSTHttpsURLConnection(sbU4.toString(), activityPackage, i);
            IPackageHandler iPackageHandler = this.packageHandlerWeakRef.get();
            if (iPackageHandler == null || (iActivityHandler = this.activityHandlerWeakRef.get()) == null) {
                return;
            }
            if (responseDataCreatePOSTHttpsURLConnection.trackingState == TrackingState.OPTED_OUT) {
                iActivityHandler.gotOptOutResponse();
            } else if (responseDataCreatePOSTHttpsURLConnection.jsonResponse == null) {
                iPackageHandler.closeFirstPackage(responseDataCreatePOSTHttpsURLConnection, activityPackage);
            } else {
                iPackageHandler.sendNextPackage(responseDataCreatePOSTHttpsURLConnection);
            }
        } catch (UnsupportedEncodingException e) {
            sendNextPackageI(activityPackage, "Failed to encode parameters", e);
        } catch (SocketTimeoutException e2) {
            closePackageI(activityPackage, "Request timed out", e2);
        } catch (IOException e3) {
            closePackageI(activityPackage, "Request failed", e3);
        } catch (Throwable th) {
            sendNextPackageI(activityPackage, "Runtime exception", th);
        }
    }

    private void sendNextPackageI(ActivityPackage activityPackage, String str, Throwable th) {
        String string = Util.formatString("%s. (%s)", activityPackage.getFailureMessage(), Util.getReasonString(str, th));
        this.logger.error(string, new Object[0]);
        ResponseData responseDataBuildResponseData = ResponseData.buildResponseData(activityPackage);
        responseDataBuildResponseData.message = string;
        IPackageHandler iPackageHandler = this.packageHandlerWeakRef.get();
        if (iPackageHandler == null) {
            return;
        }
        iPackageHandler.sendNextPackage(responseDataBuildResponseData);
    }

    @Override // com.adjust.sdk.IRequestHandler
    public void init(IActivityHandler iActivityHandler, IPackageHandler iPackageHandler) {
        this.packageHandlerWeakRef = new WeakReference<>(iPackageHandler);
        this.activityHandlerWeakRef = new WeakReference<>(iActivityHandler);
    }

    @Override // com.adjust.sdk.IRequestHandler
    public void sendPackage(final ActivityPackage activityPackage, final int i) {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.RequestHandler.1
            @Override // java.lang.Runnable
            public void run() {
                RequestHandler.this.sendI(activityPackage, i);
            }
        });
    }

    @Override // com.adjust.sdk.IRequestHandler
    public void teardown() {
        this.logger.verbose("RequestHandler teardown", new Object[0]);
        ThreadExecutor threadExecutor = this.executor;
        if (threadExecutor != null) {
            threadExecutor.teardown();
        }
        WeakReference<IPackageHandler> weakReference = this.packageHandlerWeakRef;
        if (weakReference != null) {
            weakReference.clear();
        }
        WeakReference<IActivityHandler> weakReference2 = this.activityHandlerWeakRef;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        this.executor = null;
        this.packageHandlerWeakRef = null;
        this.activityHandlerWeakRef = null;
        this.logger = null;
    }
}
