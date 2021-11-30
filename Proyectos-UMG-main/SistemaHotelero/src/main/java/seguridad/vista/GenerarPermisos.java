package seguridad.vista;

import Finanzas.vista.*;

import java.net.UnknownHostException;
import seguridad.dominio.Permisos;

/**
 *
 * @author Diego Vásquez
 */
public class GenerarPermisos {

    Permisos ejecutarPermisos = new Permisos();

    public void getPermisos(String modulo, String usuario) {
        try {
            if (modulo == "Seguridad") {

                MDI_Sistema.JMenu_Mantenimientos.setVisible(false);
                MDI_Sistema.JMenuItem_Usuarios.setVisible(false);
                MDI_Sistema.JMenuItem_Aplicaciones.setVisible(false);
                MDI_Sistema.JMenu_Asignaciones.setVisible(false);
                MDI_Sistema.JMenuItem_Perfiles.setVisible(false);
                MDI_Sistema.JMenuItem_Modulos.setVisible(false);
                MDI_Sistema.JMenuItem_AplicacionesUsuario.setVisible(false);
                MDI_Sistema.JMenuItem_Bitacora.setVisible(false);

                ejecutarPermisos.ejecutarBusqueda(usuario);

                for (int i = 0; i < ejecutarPermisos.getAplicaciones().length; i++) {
                    int varApp = Integer.parseInt(ejecutarPermisos.getAplicaciones()[i]);
                    if (varApp >= 10 && varApp <= 99) {
                        MDI_Sistema.JMenu_Mantenimientos.setVisible(true);
                        switch (varApp) {
                            case 10:
                                MDI_Sistema.JMenuItem_Usuarios.setVisible(true);
                                break;
                            case 20:
                                break;
                        }
                    }
                    if (varApp >= 100 && varApp <= 199) {
                        MDI_Sistema.JMenu_Asignaciones.setVisible(true);
                        switch (varApp) {
                            case 100:
                                break;
                            case 200:
                                break;
                        }
                    }

                }
            }
            if (modulo == "Finanzas") {

                MDIFinanzas.JMenuCatalogos.setEnabled(false);
                MDIFinanzas.JMenuProcesos.setEnabled(false);
                MDIFinanzas.JMenuInformes.setEnabled(false);
                MDIFinanzas.JMenuClasificacionCuentas.setEnabled(false);
                MDIFinanzas.JMenuPeriodoFiscal.setEnabled(false);
                MDIFinanzas.JMenuTipoTransaccion.setEnabled(false);
                MDIFinanzas.JMenuCuentasContables.setEnabled(false);
                MDIFinanzas.JMenuTipoAsientoContable.setEnabled(false);
                MDIFinanzas.JMenuDivisas.setEnabled(false);
                MDIFinanzas.JMenuCuentaBancaria.setEnabled(false);
                MDIFinanzas.JMenuPersonaBancaria.setEnabled(false);
                MDIFinanzas.JMenuBancos.setEnabled(false);
                MDIFinanzas.JMenuCuentahabiente.setEnabled(false);
                MDIFinanzas.JMenuItemAsientoContable.setEnabled(false);
                MDIFinanzas.EncabezadoAsiento.setEnabled(false);
                MDIFinanzas.JMenuItemTB.setEnabled(false);
                MDIFinanzas.JMenunEmisionCheque.setEnabled(false);

                ejecutarPermisos.ejecutarBusqueda(usuario);

                for (int i = 0; i < ejecutarPermisos.getAplicaciones().length; i++) {

                    int varApp = Integer.parseInt(ejecutarPermisos.getAplicaciones()[i]);

                    if (varApp >= 1000 && varApp <= 1100) {
                        MDIFinanzas.JMenuCatalogos.setEnabled(true);
                        switch (varApp) {
                            case 1000:
                                MDIFinanzas.JMenuClasificacionCuentas.setEnabled(true);
                                break;
                            case 1001:
                                MDIFinanzas.JMenuPeriodoFiscal.setEnabled(true);
                                break;
                            case 1002:
                                MDIFinanzas.JMenuTipoTransaccion.setEnabled(true);
                                break;
                            case 1003:
                                MDIFinanzas.JMenuCuentasContables.setEnabled(true);
                                break;
                            case 1004:
                                MDIFinanzas.JMenuTipoAsientoContable.setEnabled(true);
                                break;
                            case 1005:
                                MDIFinanzas.JMenuDivisas.setEnabled(true);
                                break;
                            case 1006:
                                MDIFinanzas.JMenuCuentaBancaria.setEnabled(true);
                                break;
                            case 1007:
                                MDIFinanzas.JMenuPersonaBancaria.setEnabled(true);
                                break;
                            case 1008:
                                MDIFinanzas.JMenuBancos.setEnabled(true);
                                break;
                            case 1009:
                                MDIFinanzas.JMenuCuentahabiente.setEnabled(true);
                                break;
                        }
                    }
                    if (varApp >= 1101 && varApp <= 1200) {
                        MDIFinanzas.JMenuProcesos.setEnabled(true);
                        switch (varApp) {
                            case 1101:
                                MDIFinanzas.JMenuItemAsientoContable.setEnabled(true);
                                break;
                            case 1102:
                                MDIFinanzas.EncabezadoAsiento.setEnabled(true);
                                break;
                            case 1103:
                                MDIFinanzas.JMenuItemTB.setEnabled(true);
                                break;
                            case 1105:
                                MDIFinanzas.JMenunEmisionCheque.setEnabled(true);
                                break;
                        }
                    }
                    if (varApp >= 1201 && varApp <= 1300) {
                        MDIFinanzas.JMenuInformes.setEnabled(false);
                        //PENDIENTE PARA REPORTERÍA
                    }
                }
            }
            
        } catch (NumberFormatException ex) {
            System.out.println(ex);
        }
    }

    public String[] getAccionesAplicacion(int codigoAplicacion, String usuario) {
        ejecutarPermisos.ejecutarBusqueda(usuario);
        String[] matrixPermisos = new String[5];
        for (int i = 0; i < 5; i++) {
            matrixPermisos[i] = ejecutarPermisos.getPermisosApps(codigoAplicacion)[i];
        }
        return matrixPermisos;
    }
}
