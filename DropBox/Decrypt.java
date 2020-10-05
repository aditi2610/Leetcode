package DropBox;

public class Decrypt {
    public static String decryptPassword(String s) {
        StringBuilder password = new StringBuilder(s);
        for (int i = 0; i < password.length(); i++) {
            int length = password.length();
            char current = password.charAt(i);
            if (Character.isDigit(current)) {

                int j = length - 1;
                while (j > i) {
                    if (password.charAt(j) == '0') {
                        // delete 0
                        password.replace(j, j + 1, current + "");
                        password.deleteCharAt(i);
                        i--;
                        break;
                    }
                    j--;
                }

            }

            else if (i <= length - 3 && Character.isUpperCase(current)) {
                char nextChar = password.charAt(i + 1);
                char nextToNext = password.charAt(i + 2);
                if (Character.isLowerCase(nextChar) && nextToNext == '*') {
                    // StringBuilder temp = new StringBuilder(nextChar+"" +current);
                    password.replace(i, i + 3, nextChar + "" + current);
                    i += 1;
                }

            }
        }

        return password.toString();

    }

    public static void main(String[] args) {
        Decrypt decrypt = new Decrypt();
        System.out.println();
        System.out.println(" " + decrypt.decryptPassword(
                "16272737619992476778599564747665867964694672336192758786291976779991215417866479123841292261438823665555848933985545298475555472121278566245923667129246388613384744546184685768438777639198578445734167388189648781413852778427798778468167394342362143468411474897364162958814523837835327627988118591573543711525721777826274118192161973235612183976819373794973923144229897687684779821225916985176926153956795539441298483551635455224424487182819562293139689338372995955475867645185555349174274531452449526582778186297535187578767936783116138953489673939513549595983486854514942931194942588191676799228124911185344424161818222795958967638645741524219542981484555929469293727574783887979788369682837536934519825385521743789476547841264353989232739831323693766583863361568737921813634924117264951779286569841645385279219823525951541294762352435717566777467283257523656783394913523413322853163831932479695322325488564289922789491416462331122699393129932925659361492349483813386899736296142727614721564543879237369681699726222232Ghmx0tDx*O0J0vjJx*yew0TPK0Po*Eg*0F0DDOIt*SGORQwFt*CYpJd*iUb*n0wzZu*0Bb*YW0reLd*0TqTf*QrKz*IAi*gMg*0Fl*CMEk*SyfqKc*0ywTn*bXe*0LBWq*0GYHLtLw*CGp*Zh*00sLy*0EvRp*F0EmOy*LX0My0Sf*Gv*ruwrqnDw*0Fw*Jz*Ok*Cy0yb0Hh*ujOn*0HqUa*JSd*o0Q0Ix*M0t0BKs*0JIB0o0Bv*zZi*00jRv*Cq*Y0S00CTNz*0ZUCgLc*0Td*Vu*rXu*fSh*dv0Wu*Ko*nw0ESPSRo*nBb*Ss*bwBa*Qa*HSn*L0Sjf00TDVu*LZb*mjRl*Uu*IGVU00z0UBmVw*Ez*LVu0bAq*Kn*Lhur0JOSMo*qsqr0GIUXi*vKp*Wa0Ct*IJXw0lFh*h0NJY0DNh*wWe*Nx*000DH0rAb*cvMs*TIi0Sj*X0eRw*OPEi*b0Gd*Gg*r00Gp*JvMt*qaPe*apFo*DNQt*cLa*0Qk*jQx*00FoAh*Is*IxKl*Jh*hCm*OTYHXz*GYv*a0WMv*Sh*XD0VicwnSy*JFloat0Dr0a0G0DKz*wOn*rat0NBMVy*Ig*cCq*dm0Ef*0Rw*bm0FLhIe*0Nm*whuOd*Jl*c0V00UF0Ox*Cc*0ZQR0ce0BCg0KS0Jm0OuYs*jHm*Apkn0xMj*Fg*Jt*BTF0KIEg*0X0kEz*XtjbgAo*Er*dNd*W0K0K0x0Hy*TkmcHm*dnGv*Shf0zVc*Qh*rZc*XqaxHk*pIb*Te*Yt*JDs*SFt*KhMo*m0OvjicXu*jcjyXz*Bi*We*Mmmd0V0E0ZJi*IdQq*TOIu*u00ZNQnw00Cm0WOGq*OThTk*00A0TUDGtEj*PnTv*bkYp*Ro*Xo*xBt*SQj0Bd*RwcZt*OC00O0EJl*on0TO0Md*Ux*YJ0sJc*n0zIi*QRAl*NJUA00YYTr0Nmo0Wd*0eBk*0KH0Iv*svrDt*Ms00qPr*TJF0rKf*i0x0lVp*0D0GFafdqhrqidOs*MFzsjv0GSdcJf*Sw*iCu*Qy*L0Kd*ZBk0Yv*Jo*cvzjzCm*0YHu*Jb*hVw*0TGYA0nhf0ubd0RTBQTKQBRm*Hb*0BMLNb*mOa*LI00EU0d00hsqXy*YfmVe*UUe*Nk*hwHh*SACl*0U0Ea*WHdr0Qt*PNCZLGqj000B0nwpwVw*Iai0KOp*rEg*s0gentmmXh*Obn0Gg*0Le*0gkZd*jVv*AJS00m0Ex*MPYu0Nh*NHm0uwZm*FFw*He*w0jvpapOc*ZXq*Vs0KNsebTv*Qp0hm0HAk*APAPl*di0LQn*T0Me*Ej*0CVcwrUq*Nq0lJz*uoxkGm*BmxkvMo*XvVu*FWUCQVXQm*Zg*W0Tn*Eb0Ld*hBk*0Bb*G0x0Tv*hxwwiVz*Xe*IemexCv*Ja*Ts*0CCVEu0HYsr0RFk0f0r000Bv*0iEp*SYg*Hw*MI0vVq*qv0TOMVWk*LoypQk*FTPw*p0nQr*jLv*TunnzfkYp*Nz*0Sv00Xn*Zo*y0RIu*0LY0ESIj*YBv*GXKEFi*Hw*0OqMo*RGnCf*Cw*Ay*00s0MUTfoIa*C0HPHxCp*cj0PJRl*Fc*Dx*TrtxQa*Mm*RKJiRp*GDQu0uxzzDt*UUFLd*sZv*Jv*oj0kggbNr*EHRa*QiZe*ATL0t0gYe*H0ZG0fv0LUUSVn*Ry0BAm00CQh*s0Mi*AEh*GCe*Rl*HuUf*YQ0DPEZKHnEk*oafaruAa*LdDr*PgRz*EoxBc*0gGp*XxuiVe*Xz*YO0GKhgYu*WEx*KEi*RVj*Zc*MNXA0pXg*CSIEJSb*OlUg*Uf0xtVx*MP0Yb*0jWk*cEx*0Fqv0h0E0QEy*Lax0vwSu*BYMZMIHb*0czZb*eyRu*Cm*W00j0Y00WTjswc0zwAx*KWIXWk*0rueybEu*kRj*0Ax*wxvDg*FnSn*FVHt*PROI0DDwHl*e0Ow*ajNz*wi0JPLHUq*CSl*E00g0n0GMIb*BaNg*0AzCz*mCi*P0Ou*0T0QKu*0Di*Uf*ijeoXm*rgaVz*T0CyvUn*Lx*Ex*Wk*KMGg*Ke*Wo*HDPy*NRf*0Au*ISLSXXv*FigwDu*P0NUt0jcMc*Mk*Vr*HXBg*vkJb*T0fDp*Ds*FAh*Mk*Er*A0DOoNb*Uh*GV0Tq*0Jz0Da0mZx*Zobar0DTn0Fx*Ji*aAw*0qgBx*WIt*giRh*Ii*m0x0D0TQHc*00dt000ZK0V00Kw0Bf*If*Vy*GjpfhPa*Ev0bv0OLmsZo*AJEATSRw*HHXFwy0IBXBv*kv00Dn*NPYMu*uu0T00yBo*Gr*Ud*QoVp*0LVWHigPf*LEAj0Uo*x0rUh*Ug*0Ul*0AjAn*00Af*OWVNj*j0TIDJEt*0FhPt*L0Pe00A0HMMg*00UgOo*khsJm*0hOj*v0PPRDre0E0Jh*Ej*ZAc00Em*EOp*mo0YH0HOELw*Hf*0lz00o0WBj*Ke0YCUBy*VCdj0PrwSg*JxYr*Zhe0UorHr*0Ze*QSf*sEi*Rbj0z0Bh*VIh*h0PzXd*CNhDf*DhTv*VYXq0f0J0GOcEs*EJe*UJVh*Op*lUv*CKs*ILAv*C0Zi*WeHh*BGu0pGg*mcpf0sRc*Cg*JQGYy*0gEd*AaYi*Do*lSx*Yw*0FnFz*dvrUl*qZa*fFl*hXc*WVHd*cvpNl*DDGB0q0PRBl*PGBLl0QgBa*Qva0U0ALb*MUJQ0000Tf*AnOu*YSFn*IBfpNv*FUY0Is*Dv*DHIv*WAsBp*Nd*YQKi0Rwo00ZHLJZ0hPu*0UXh*0fJv*b0aFu*00QFKGrcDy*gNe*SOLj*I0PKPM0fmCv*WHFe*TIFfVc*Bl*0Br*GQFP0HHGh*t0PEzHv*0Hz*Fz*TKC0KZHk*g0Pb0ej0KhfJf*Knytah0CAt*GyTw*Nx*0pEe*Ss*0MKRi*DTSAe*JMNq*Es*zvNr*PYq*dKs*Ix0LCw0M0uAt*0HNh*oom00cXa*00pJt*pGs*PLm*0JEZ0Jxag00Uc*b0srbxJd*AUxXd*s0r0qxEy*Kz*FVpzeWs*0Pk*0gFh*0WKCa*Vo*0Fs*0Oh*O0p0o0ejEp*yp00WV0ZxBg*T0Iy*jAi*PNBvJq*k0E0Fu*yv0Js0Vn*fFr*RXNNHj*00HQi*Ec*0i0aOd*d0G0RYBthweztQo*MTQAT0x0XKW0IMZ00HYKbne00OR00eMv*bHk*evsa0N0USLZz*L0Lj*ZRn*gujKw*PW0Djc0CZBt0Yl*F0Mw0age0VPi*KDg*h0VbEz*Dd0tm0OXQfLu*TRDBqx0Y0GktTo*ec0Ov*MSSJUOFCp*WYK0z0X0kzh0JZQQNQg*jYa*Bi*Pa*Yx*EIB0Fk*00SGq*00KZj0YSh*ZZbIn*0Xg*0Nt*hxh0W0i0PK0Ci*Mim0HD0l0YFanPe*mWz*iv0jDw*Fu*GIM0vvq0pPd*iwZn*Jm*llZa*0Fy*Ot*Gkz0nnSl*IfMo*c0I0WKr*La*Xp*0WPrjdCz*NSMCv*gtSj*R000Pc*MebUr*QHs*Gy*aDp*LyTh*MBQAi*EGa*dIx*0U0KCENWvyCu*veg00C0Ie*i0Fx*MRe*rvNv*CCl*FZZr*Tm*BM0kAy*Rc*Wy*KHHVs0Gf0iTr*piXy*d0rpRt*UoDi*0u0HHp*0dhNl*AMXg0YcXa*0zhyd0DUo*Qi*Rz*0jHx*Iq*Rk*GY00Q0ekvh0q0wb0an0eqnzy0Wo*BSYm*Yv*e0Oq*nHx*Zqdb0Xx*VYl*MLLu*DDn0m0NGQQJMFy*cmQl*By*0oxCo*Mn*B0I0Vhvmzq0s00TWAUHdcbsJh*OOPx*Cb*QFEOC0BLEUn0LlWq*H0yfz0PMh*De*Wv*CFHk*MQu*k0of0NFV0o000Io*q0EBq*0T0Cz*Zb*Hyiha0WqHz*oLj*kYj*0WQPu*TNSa*o0XTLCBD0brqeaxOd*iQi*T0aehId*rYj*Jh*0Y0nwAq*SIi*MZb*Ru*Ym*oSn*Fq*yt00Uy*aRf*UUUb*Paq0VAk*Dl*Sc*c0YXo*dEe*En*Vvj0wqbMo*KhUp*d00GNDMFLx*JS0H0D0BT0JNzXq*Evo00e0JU0JQWAdv0Uf*GNYr*Hrq0Hd*qopiHl*i0WHc0o00IPv*O0Nh*bt0fGs*0HSgKm*St0INAfIv*0Xd*0Au*0WN0VxNc*0mIz*Yk*YXDUg*YFx*a0YJkhGz*aRz*00Ws*fypwtba00R0YSEnAh*INFk0P0u0uqRy*Op*iWo*Snns000B0Hm*Nm*oazAw*W0WMg*Vf*Ax*Yj*NQ0Nj*JAPFbsSe*AUBNk*OXCb*Eo*ehPm*wdCy*HQi0DUg0WIo*l0HQz*00LS0XTud0HrcvgpyuoFd*SNu*X0SHd*IAb*n0Cecv0if00vveTp*REcoxzDk*QCPy*QQq*j0drJs*DHvrTc*GNo*CZs*CHxJg*FyXx*RrvNk*MNz*0Ez*0Bitf0Mf*zZa*m0pxszHs*E0Iq*ribEd*OORh*sgx0K0Dlv0PEBd*y0MBOyw0lXv*YCMs*GZsWo*0TdOb*ZPJiZa*Fk*MHa*DKAZh*0Vr0hz0qBc*x0JCHi*Ya*Ja0HRG0WWj*BZfz0In*dc0f0OLBEEm*ZVrsotSq*ptf0AYJSzDy*is0KNt*Cj*TECw*FGz*EoyiOs*Ju*CFw00zsxekSr*c000tRl*LP0Qrh0c0UBa*a00a0Yr*P0AMQ0DGufk0Pf*En*mnIe*ZIi*M0D00IZZdcTf*Ng*Aqqv00P0UBTJc*SRw00OnCg*GLTz*Zb*Qwole0Sg*FB0GmuRc*HgyiVo*Ca*dTp*Il*Yx*st0Ylglch0Ij0Y0Gw*o0wfg0TOZZgsbUm*Fke0Ob*dfywKr*tn0hd0Tv*0AYJ0AE0DN00000RFFtPo*0k0VI0utAm*00UYSYrp0As0SiNw*SpYm*USADD0URBt0Qt0ngjwnbFh*Yu*Ys*XEb*IqQw*0CNNbp0Dm*0XPd*"
                        + "00Vj*YQSDLp*UTP0Us*EIQc*00Se*xZr*kmAr*0Ot*On*uVy*FPi*G00WQamip0nw0tNm*"
                        + "CPDUt*oAy*X0SFHf*oMt*eiWs*QphdPh*vOn*Eu0XAsnw0ODZNbbpmFz*0NKs*LNDOwBb*AKYb*"
                        + "0J0VAo*Im*H0tkCc*Xg*ZA0p000Qa*k0O0Eq*IlIy*0Zd*N00Ktl0RCHorcEu*jYs*l0PrVz*00Tq*ESAt0BRc*"
                        + "Dqrlhfmqu0u0XS0Dc*Di*RUk*WZhAg*Kt*Me*0D0Jd*Rv*Gb*IFu*Rl*Qw*jyRw*VWHt*TqWd*enhrcrpip0tjf00v0HQl*"
                        + "v0E0hXg*WSi*Ffi0P0q00oXm*Bb*0DJo*XTIAa*TYV0qSa*ROk00Pu*AHe*kvvPu*Db0z0BRWPg*q0Cv00GBy*HyaPr*Gg*"
                        + "r0Vmhl0Uk*oeZp*E0PTOj*YFYa0nnFm*AUVXVtt0fisPu*ca0RIFr*XSK0DsnsnWr*Wn*Xk*Eh0EMiRd*Fep000DfUz*"
                        + "Pu0tnEp*BRHSBga0BA0Gu*0uUx*ArDb*VkBw*rdMf*Dm*Eu0WPr*0buwIy*00Ul*VAPu*PGWXUr00GdId*MRJFg0WIj*"
                        + "KhYu*oSc*0Kf*hHr*VQub0RQg*QtVw*SlOn*Kl*zOk*AMq*0Mw*ougxoGn*Dd*vXa*R0gXr*M0RC0So*Lp0alPa*"
                        + "0PFMm*Da*0v0rIm*El*Xq*JsTk*B0g0Zw0Um*Ks*0uAs*iwwZa*0GC0HcMe*LpmmuQa*0Gy*Tu*SGu000Wd*"
                        + "PpBy*FVrZv*ZKr*0EIDM0zwwle00SQASee0bgPg*CFk*LQo*FFUKq*LjKd*enZe*xcNt*XOTUu*0Ak*Zl*"
                        + "0Do*PSS0EQ0Jz*FeUw*wc0JVk*ZDn*Guh0qSd*BXan0imRi*0Cjsf00ZobHa*0A0QL0MF0XlOr*Jxtow0Bh*l0OOo*P0Aa*"
                        + "NWw*VmRi*0yTz*wWe*t0f0SDUCBh*VHPb*UnYu*Li0Q0GHs*H0Jt*j0eSu*I0JPMn*LZm*UIH0KUp*Aa*j0QLtFw*MWg*DSTy*"
                        + "Hd*f0Um*fh0wzQe*INl*Sh0yNu*Mz*YQZCq*eqb0ScPp*0PQq000MXQ0Zx*0a0Zf*dUd*VASCv0amRc*rciJj*Iz*wo0l0Vj*V0OS000tOk*"
                        + "0VBPSUTsQe*Na*WvhQf*IVSRvLw*Eq*Eo*RJBVzjWa*MPu0fqHc*ZRUNpGh*0D00ETl*QQMn*pcbNa*vBf*mKa*SCZOf*dWz*VXXEc*MHB0xSh*WZa*"
                        + "ZkEe*0I0Tyqzbx0I0Nu*YP0X0KMz*FLHk*Dc*rfsy00ZLe*BUGMUBjyFi*Co*Ojzd0Ih*T0GBFc*0OnjUu*0Si*vkHq*IXWj*Wk*aIp*vtFz*Ud0Y0E0p0Yd*M0To*RbvPi*R0KXt*YVl*0Ux*psQk*nNu*Z0Vs*0Lg*FtCt*CIOJtypg0GHq*UQ0TA0Cb*j00nKv*bIg*ZCt*BG00S00WCn*Cd*XVPk*0IlQz*0VPc*00UWsk0Jt*0Dg*LFYLfac0DR0CJMNd0H0LblwJq*Eo*NIWxFh*isruZg*UPeJg*E0NL0J0KKwc0vOr*Herh0ku0CWVc*yhqkpKz*0EFu*JZt0Ur*Z00000MJWy*Ry*0rbCk*Cr*xcdmJq*qVm*fLr*Gw*DModlUo*aIw*0AZa*Ix*AQQm*Lex0Sh*VX0CokeAc*Ko*ORUX0FVAYXz00Fe*Cv*FFE0h0BHBh0Hb*KOx*c00l0Ko*XPihzEm*eu0xbOv*0L0RGrJf*U0h0Mc*BNYCd*Xd*Zy*LeHr*IRJPE00Pq*Of*Va*0I0kiRj*kkqzRf*Yv*y0Bv*b0PXEYDVNe*KJg*To*aJm*IWu*Cn0UGEKq0DfWx*Sz*CFDR0Di*aacJf*j0Bh*WNl*Gm*Ao*ICjHa*Kq*mLk*btkTc*hpk000UIBusaQb*q0c0Jq*Vj*MKTuOh*Xk0Iw*bCq*q0QEXb*FRPgcguAi*Nt*r0JsGz*CHu*XSed00LYl*DWIRmKk*jKo*R0PZa*0Ui*EceBs*fy0rKw*0Cf*Hq*g0X0GkbEu*W0HBJh*Sk0VN0fgjSt*"
                        + "KBxlnRm*CSw*gyfx0IVa0YHN00eetf0Gp*YHu*Zo0KTi*w0eWy*Vv*Ua*ZYlvOt*YGs*RGoVi*oy0mGr*kw0Sf*0PQNGWYKf*xZj*0EevoeMh*0g0PvQw*cOx*Tr*nZs*MAwEc*LQWk*0C0yzkvrep0dEv*MGa*0JLU0PE00ges0t0JNn*Ux*Ke0hRk*PEidmd0Pv0GYGPcXd*MYfYc*obVr*QTOm*LMu*0XbewJa*Ej*Ynrm0Iz*Hh*0Dh0e0av0HSp*Xd*IWvrKx*Il0pbQy*CEwrz0iXp*iRh*FOL0Nm*XBw*QICa0OYNANOBnhvPm*0WSafp0ZJy*BOJn*ELxOq*0Xg*PS0HyLc*Un*x0Qz*Wz*RWz*faWc*y0FXXw*0DMNZa*DOWp0Ym*ih0YVf*un0e0OQPjOc*Q00CiSc*Nl*LSXnJe*aRd*0OGpBg*Pm*Ip*VOd*DipTp*Pm*PJ0rIe*j0rcabqb0phCy*0Xo*0Wf*Ys*DDKTCt*PZdBg*qgNs*0IuEg*Hu*VHKDwlwiuLw*0KBDf0ZJNYht0ya0Ha*0ES0c0a0g00sr0Xn*VUl*0Ql*NEw*t00KW0HHr00OCx*zSb*vTf*ARNi*es00MHa*d00pVo*R0Pd*J0ucvJs*I0FJUl*Pr*Ytqb00MuRi*Lo0Cz*ZIi*Ho*Up*oXp*0cvSg*WO0JXj*Noch0Q0ABs*JJ0Zt*Nrj0NGHpDk*Ml*eAi*Iq*Sg*c0MAMLDbWj*jliHt*e0GAKUx*r0qn0YFr0Cb*HICA0Cr*0zRy*Ak*N0CAlSf*xhc00LQZDDg00GKLYn0bVv*Nu*XFVg0g0aXl*QXz*taAj*adKb*Sd*DOw*00SIwTi*V00MVJUBb*00Su*FVEt*MRW0VOS0Ju*Va*FowrBi*HemPm*AWBrUb*y0RCt*0Tp*Vn000u0JO0Sn*RSb*GEFh*dBm*Fi*KKNTYvweXu*Zg*SPk0M000v0BBRtb0Fz*Za*WEGc*Hdm0y00RuKb*MgeqHh*zdFq*vbsasSv*s0q0Vr*0K0sDs*N0X0r0u0KNIZHXk*QYW0"
                        + "APlAk*qzjdf0Qp*"));
    }

}