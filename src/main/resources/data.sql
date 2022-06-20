INSERT INTO public.roles(
    id, name)
VALUES (1, 'ROLE_USER');

INSERT INTO public.roles(
    id, name)
VALUES (2, 'ROLE_MODERATEUR');

INSERT INTO public.roles(
    id, name)
VALUES (3, 'ROLE_ADMIN');

INSERT INTO public.rencontre(
    id, created_at, description, nombre_joueur, owner, planned_at, sport, city, postal_code, latitude, longitude)
VALUES (1,'18/06/2022','desc',3,1,'18/06/2022','FOOTBALL','sarcelles','95200','37.78825','-122.4324');

INSERT INTO public.rencontre(
    id, created_at, description, nombre_joueur, owner, planned_at, sport, city, postal_code, latitude, longitude)
VALUES (2,'18/06/2022','desc',3,1,'18/06/2022','FOOTBALL','sarcelles','95200','37.98825','-121.4324');