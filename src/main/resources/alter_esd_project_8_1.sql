ALTER TABLE organization_hr
ADD CONSTRAINT fk_organization_id
FOREIGN KEY (organization_id) REFERENCES organizations(id) ON DELETE CASCADE;
