package com.example.masco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class present extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present);
        private Context context;
        private IMainActivity.Vista vista;
        private IMainActivity.Modelo modelo;

    public PresentadorMainActivity(Context context, IMainActivity.Vista vista) {
            this.context = context;
            this.vista = vista;
            modelo = new ModeloMainActivity(context, this);
        }

        @Override
        public ArrayList<Fragment> agregarFragment() {
            ArrayList<Fragment> fragments = new ArrayList<>();

            fragments.add(new InicioFragment(modelo.consultarMascotas(), this));
            fragments.add(new PerfilFragment());

            return fragments;
        }

        @Override
        public int cantidadFavoritos() {
            return modelo.consultarCantidadFavoritos();
        }

        @Override
        public void actualizarVista() {
            vista.actualizarVista();
        }

        @Override
        public List<MascotasEntity> mascotasFavoritas() {
            return modelo.consultarMascotasFavoritas();
        }


        @Override
        public void actualizarFavoritos(int id, int favorito) {
            modelo.actualizarFavoritosBD(id, favorito);
        }

        @Override
        public void actualizarLikeMascota(int id, int cantidadLike) {
            modelo.actualizarLikeMascotaDB(id, cantidadLike);
        }
    }
}